package com.tracebucket.x.terminal.api.rest.controller;

import com.tracebucket.tron.assembler.AssemblerResolver;
import com.tracebucket.tron.ddd.domain.AggregateId;
import com.tracebucket.x.terminal.api.domain.Position;
import com.tracebucket.x.terminal.api.domain.Terminal;
import com.tracebucket.x.terminal.api.rest.exception.TerminalAPIException;
import com.tracebucket.x.terminal.api.rest.resource.PositionResource;
import com.tracebucket.x.terminal.api.rest.resource.TerminalResource;
import com.tracebucket.x.terminal.api.service.TerminalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by sadath on 18-May-15.
 */
@RestController
public class TerminalController {

    private static Logger log = LoggerFactory.getLogger(TerminalController.class);

    @Autowired
    private TerminalService terminalService;

    @Autowired
    private AssemblerResolver assemblerResolver;

    @RequestMapping(value = "/terminal", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminalResource> createTerminal(@RequestBody TerminalResource terminalResource) {
        Terminal terminal = assemblerResolver.resolveEntityAssembler(Terminal.class, TerminalResource.class).toEntity(terminalResource, Terminal.class);
        try {
            terminal = terminalService.save(terminal);
        } catch (DataIntegrityViolationException dive) {
            throw new TerminalAPIException(dive.getRootCause().getMessage(), HttpStatus.CONFLICT);
        }
        if(terminal != null) {
            terminalResource = assemblerResolver.resolveResourceAssembler(TerminalResource.class, Terminal.class).toResource(terminal, TerminalResource.class);
            return new ResponseEntity<TerminalResource>(terminalResource, HttpStatus.CREATED);
        }
        return new ResponseEntity<TerminalResource>(new TerminalResource(), HttpStatus.NOT_ACCEPTABLE);
    }

    @RequestMapping(value = "/terminal/{terminalUid}/position", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminalResource> placeTerminal(@PathVariable("terminalUid") String terminalUid, @RequestBody PositionResource positionResource) {
        Position position = assemblerResolver.resolveEntityAssembler(Position.class, PositionResource.class).toEntity(positionResource, Position.class);
        Terminal terminal = null;
        try {
            terminal = terminalService.placePosition(position, new AggregateId(terminalUid));
        } catch (DataIntegrityViolationException dive) {
            throw new TerminalAPIException("Position With Code : " + position.getCode() + "Exists", HttpStatus.CONFLICT);
        }
        TerminalResource terminalResource = null;
        if(terminal != null) {
            terminalResource = assemblerResolver.resolveResourceAssembler(TerminalResource.class, Terminal.class).toResource(terminal, TerminalResource.class);
            return new ResponseEntity<TerminalResource>(terminalResource, HttpStatus.OK);
        }
        return new ResponseEntity<TerminalResource>(new TerminalResource(), HttpStatus.NOT_ACCEPTABLE);
    }

    @RequestMapping(value = "/terminal/{terminalUid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminalResource> getTerminal(@PathVariable("terminalUid") String terminalUid) {
        Terminal terminal = terminalService.findOne(new AggregateId(terminalUid));
        TerminalResource terminalResource = null;
        if(terminal != null) {
            terminalResource = assemblerResolver.resolveResourceAssembler(TerminalResource.class, Terminal.class).toResource(terminal, TerminalResource.class);
            return new ResponseEntity<TerminalResource>(terminalResource, HttpStatus.OK);
        }
        return new ResponseEntity<TerminalResource>(new TerminalResource(), HttpStatus.NOT_FOUND);
    }


    @RequestMapping(value = "/terminals", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<TerminalResource>> getTerminals() {
        List<Terminal> organizations = terminalService.findAll();
        if(organizations != null && organizations.size() > 0) {
            return new ResponseEntity<Set<TerminalResource>>(assemblerResolver.resolveResourceAssembler(TerminalResource.class, Terminal.class).toResources(organizations, TerminalResource.class), HttpStatus.OK);
        }
        return new ResponseEntity<Set<TerminalResource>>(Collections.emptySet(), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/terminal/{terminalUid}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteTerminal(@PathVariable("terminalUid") String terminalUid) {
        return new ResponseEntity<Boolean>(terminalService.delete(new AggregateId(terminalUid)), HttpStatus.OK);
    }
}
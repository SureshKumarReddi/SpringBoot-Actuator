package com.Suresh.CustomEndPoint;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "release-notes")
public class CustomEndpoint {


    Map<String, List<String>> releaseNotesMap = new LinkedHashMap<>();

    @PostConstruct
    public void initNotes() {
        releaseNotesMap.put("version-1.0", Arrays.asList("Home page created", "Adding a new item form added", "View the watchlist page added"));
        releaseNotesMap.put("version-1.1", Arrays.asList("Reading from OMDb API added", "Actuator endpoints added"));
    }

    @ReadOperation
    public Map<String, List<String>> getReleaseNotes(){
        return releaseNotesMap;
    }

    @ReadOperation
    public List<String> getNotesByVersion(@Selector String version){
        return releaseNotesMap.get(version);
    }

    @WriteOperation
    public void addReleaseNotes(@Selector String version, String releaseNotes){
        releaseNotesMap.put(version,Arrays.stream(releaseNotes.split(",")).collect(Collectors.toList()));
    }

    @DeleteOperation
    public void  deleteNotes(@Selector String version){
        releaseNotesMap.remove(version);
    }
}
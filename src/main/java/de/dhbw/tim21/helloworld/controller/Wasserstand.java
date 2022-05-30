package de.dhbw.tim21.helloworld.controller;

import de.dhbw.tim21.helloworld.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
public class Wasserstand {



    //returns if Station exists (don't know if this is needed) {shortname} takes String of Location
    @RequestMapping(value="/wasserstaende/station/{shortname}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Messtelle> checkStation(@PathVariable(required = true) String shortname) {
        String url = String.format("https://www.pegelonline.wsv.de/webservices/rest-api/v2/stations/%s", shortname);
        try {
            RestTemplate restTemplate = new RestTemplate();
            Messtelle messstelle = restTemplate.getForObject(url, Messtelle.class);
            if (messstelle != null) {
                return new ResponseEntity<>(messstelle, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //gets every Station available (for example for a dropdown menu)
    @RequestMapping(value = "wasserstaende/allstations", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Messtelle[]> getAllStations(){
        String url = "https://www.pegelonline.wsv.de/webservices/rest-api/v2/stations";
        try {
            RestTemplate restTemplate = new RestTemplate();
            Messtelle[] messtellen = restTemplate.getForObject(url, Messtelle[].class);

            return new ResponseEntity<>(messtellen, HttpStatus.OK);
        }
        catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //gets every Station located on a specific water (for example for a dropdown menu)
    @RequestMapping(value = "wasserstaende/bywater/{water}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Messtelle[]> getStationsWithWater(@PathVariable(required = true) String water){
        String url = String.format("https://www.pegelonline.wsv.de/webservices/rest-api/v2/stations.json?waters=%s", water);
        try {
            RestTemplate restTemplate = new RestTemplate();
            Messtelle[] messtellen = restTemplate.getForObject(url, Messtelle[].class);

            return new ResponseEntity<>(messtellen, HttpStatus.OK);
        }
        catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // gets only current pegel from specif location   {shortname} takes String of Location
    @RequestMapping(value="/wasserstaende/station/value/{shortname}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Long> getCurrentPegel(@PathVariable(required = true) String shortname) {
        String url = String.format("https://www.pegelonline.wsv.de/webservices/rest-api/v2/stations/%s/W/currentmeasurement.json", shortname);
        try {
            RestTemplate restTemplate = new RestTemplate();
            CurrentPegel pegel = restTemplate.getForObject(url, CurrentPegel.class);
            if (pegel != null) {
                long wasserstand = pegel.getValue();
                return new ResponseEntity<>(wasserstand, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    ///gets Pegel from Station from the last X days - Input consists of "name/Timeframe"   name takes String of Location / Timeframe example: P10D for the last 10 Days
    @RequestMapping(value="/wasserstaende/station/values/{input}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Pegel[]> getPegelWithTime(@PathVariable(required = true) String input) {
        String[] splitInput = input.split("-");
        String url = String.format("https://www.pegelonline.wsv.de/webservices/rest-api/v2/stations/%s/W/measurements.json?start=%s", splitInput[0], splitInput[1]);
        try {
            RestTemplate restTemplate = new RestTemplate();
            Pegel[] pegel = restTemplate.getForObject(url, Pegel[].class);
            if (pegel != null) {
                return new ResponseEntity<>(pegel, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}



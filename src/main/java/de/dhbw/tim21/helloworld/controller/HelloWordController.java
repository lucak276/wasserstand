package de.dhbw.tim21.helloworld.controller;

import de.dhbw.tim21.helloworld.model.Messtelle;
import de.dhbw.tim21.helloworld.model.MesstelleList;
//import de.dhbw.tim21.helloworld.model.Pegel;
import de.dhbw.tim21.helloworld.model.PegelList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;





@RestController
public class HelloWordController {




    @RequestMapping(value="/wasserstaende/station/{shortname}", method = RequestMethod.GET)
    public ResponseEntity<Messtelle> checkStation(@PathVariable(required = true) String shortname) {
        String url = String.format("https://www.pegelonline.wsv.de/webservices/rest-api/v2/stations/%s", shortname);
        try {
            RestTemplate restTemplate = new RestTemplate();
            Messtelle messstelle = restTemplate.getForObject(url, Messtelle.class);
            if (messstelle != null) {
                return new ResponseEntity<Messtelle>(messstelle, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "wasserstaende/stations", method = RequestMethod.GET)
    public ResponseEntity<MesstelleList> getAllStations(){
        String url = "https://www.pegelonline.wsv.de/webservices/rest-api/v2/stations";
        try {
            RestTemplate restTemplate = new RestTemplate();
            MesstelleList messtelle = restTemplate.getForObject(url, MesstelleList.class);
            return new ResponseEntity<>(messtelle, HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // request for specifeic waters
    // TODO: hqere we need to add an option to request a specific time period and different location options
    @RequestMapping(value="/wasserstaende/station/value/{shortname}", method = RequestMethod.GET)
    public ResponseEntity<PegelList> getPegel(@PathVariable(required = true) String shortname) {
        String url = String.format("https://www.pegelonline.wsv.de/webservices/rest-api/v2/stations/%s/W/measurements.json", shortname);
        try {
            RestTemplate restTemplate = new RestTemplate();
            PegelList pegel = restTemplate.getForObject(url, PegelList.class);
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

    ///gets Pegel from Station from the last X days - Input consists of "name/Timeframe"    - Timeframe example: P10D for the last 10 Days
    @RequestMapping(value="/wasserstaende/station/value/{input}", method = RequestMethod.GET)
    public ResponseEntity<PegelList> getPegelWithTime(@PathVariable(required = true) String input) {
        String[] splitInput = input.split("/");
        String url = String.format("https://www.pegelonline.wsv.de/webservices/rest-api/v2/stations/%s/W/measurements.json?start=%s", splitInput[0], splitInput[1]);
        try {
            RestTemplate restTemplate = new RestTemplate();
            PegelList pegel = restTemplate.getForObject(url, PegelList.class);
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



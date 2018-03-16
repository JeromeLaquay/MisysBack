package com.jerome.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jerome.model.Podium;
import com.jerome.repository.PodiumRepository;

@RestController
public class PodiumController {

	@Autowired
	PodiumRepository podiumRepository;
    
    @RequestMapping(method = RequestMethod.GET, value="/podium")
    public Iterable<Podium> findAll() {
    	Iterable<Podium> podiums= podiumRepository.findAll();
    	return podiums;
    }
    

    
    @RequestMapping(method = RequestMethod.POST, value = "/podium", produces={MediaType.APPLICATION_JSON_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> createPodium(@RequestBody Podium podium)  {
    	try{
    		podiumRepository.save(podium);
    		return new ResponseEntity<String>("The podium was created", HttpStatus.OK);
    	}catch(Exception e){
    		return new ResponseEntity<String>("Bad request", HttpStatus.BAD_REQUEST);
    	}
	}
    
    @RequestMapping(method = RequestMethod.POST, value = "/podium/{id}/vote", produces={MediaType.APPLICATION_JSON_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Podium> sendVote(@RequestBody Podium podium) {
    	List<Long> ids =new ArrayList<Long>();
    	ids.add(podium.getItems().get(0).getId());
    	ids.add(podium.getItems().get(1).getId());
    	ids.add(podium.getItems().get(2).getId());
    	Long idpodium = podium.getIdpodium();
    	Podium pod = podiumRepository.findOne(idpodium);
    	List<Integer> points=new ArrayList<Integer>();
    	points.add(2);
    	points.add(1);
    	points.add(0);
    	for(int i=0;i<3;i++){
    		for(int j=0;j<3;j++){
    			if(pod.getItems().get(i).getId()==ids.get(j)){
    				pod.getItems().get(i).setPoints( pod.getItems().get(i).getPoints() + points.get(j) );
    			}
    		}
    	}
    	pod.setNumberOfVotes(pod.getNumberOfVotes()+1);
    	podiumRepository.save(pod);
		return new ResponseEntity<Podium>(pod, HttpStatus.OK);
	}
    
    @RequestMapping(method = RequestMethod.GET, value="/podium/trending")
    public List<Podium> trendingPodium() {
    	List<Podium> podiums = podiumRepository.voteRank();
    	List<Podium> podiumsRes = new ArrayList<Podium>();
    		
    	return podiums;
    }
    
    @RequestMapping(method = RequestMethod.GET, value="/podium/search")
    public List<Podium> searchPodium(@RequestParam(value = "namePodium", required = false) String namePodium) {
    	List<Podium> podiums = podiumRepository.findByName(namePodium);
    	return podiums;
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value="/podium/{id}")
    @ExceptionHandler()
    public ResponseEntity<String> deletePodium(@PathVariable("id") Long id){
    	try{
    		podiumRepository.delete(id);
    		return new ResponseEntity<String>( HttpStatus.NO_CONTENT);
    	}catch(Exception e){
    		return new ResponseEntity<String>("No podium was found with the given id", HttpStatus.NOT_FOUND);
    	}
    }
    
    @RequestMapping(method = RequestMethod.GET, value="/podium/{id}")
	public ResponseEntity<?> getPodium(@PathVariable("id") Long id) {
   	 try{
   		 Podium podium= podiumRepository.findOne(id);
   		 if(podium == null || podium.equals("")){
   			 String errorMessage;
            	errorMessage = "No podium was found with the given id";
            	return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
   		 }else{
   		 
   		 return new ResponseEntity<>(podium, HttpStatus.OK);
   		 }
   	 }
   	 catch(Exception ex){
        	String errorMessage;
        	errorMessage ="bad request";
        	return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    	}
	}

}

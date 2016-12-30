package labsampapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import labsampapp.models.Labsamp;
import labsampapp.repositories.LabsampRepository;

@RestController
@RequestMapping("/api/labsamps")
public class LabsampController {
	
	@Autowired
	LabsampRepository labsampRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Labsamp> getAllLabsamps() {
		return labsampRepository.findAll();
	}

	@RequestMapping(method=RequestMethod.POST)
	public Labsamp createLabsamp(@Valid @RequestBody Labsamp labsamp) {
		return labsampRepository.save(labsamp);
	}

	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<Labsamp> getLabsampById(@PathVariable("id") String id) {
		Labsamp labsamp = labsampRepository.findOne(id);
		if(labsamp == null) {
			return new ResponseEntity<Labsamp>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Labsamp>(labsamp, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.PUT)
	public ResponseEntity<Labsamp> updateLabsamp(@Valid @RequestBody Labsamp labsamp, @PathVariable("id") String id) {
		Labsamp labsampData = labsampRepository.findOne(id);
		if(labsampData == null) {
			return new ResponseEntity<Labsamp>(HttpStatus.NOT_FOUND);
		}
		labsampData.setSampdescription(labsamp.getSampdescription());
		labsampData.setCompleted(labsamp.getCompleted());
		labsampData.setBarcode(labsamp.getBarcode());
		labsampData.setBatchId(labsamp.getBatchId());
		labsampData.setCheckinDate(labsamp.getCheckinDate());
		labsampData.setCheckinPerson(labsamp.getCheckinPerson());
		labsampData.setCustomerName(labsamp.getCustomerName());
		labsampData.setFinishDate(labsamp.getFinishDate());
		labsampData.setInstanceName(labsamp.getInstanceName());
		labsampData.setProject(labsamp.getProject());
		labsampData.setResults(labsamp.getResults());
		labsampData.setSampleName(labsamp.getSampleName());
		labsampData.setShelfName(labsamp.getShelfName());
		labsampData.setStartDate(labsamp.getStartDate());
		labsampData.setStatus(labsamp.getStatus());
		labsampData.setTestStatus(labsamp.getTestStatus());
		labsampData.setWorkflowName(labsamp.getWorkflowName());
		
		Labsamp updatedLabsamp = labsampRepository.save(labsampData);
		return new ResponseEntity<Labsamp>(updatedLabsamp, HttpStatus.OK);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	public void deleteLabsamp(@PathVariable("id") String id) {
		labsampRepository.delete(id);
	}
	
}

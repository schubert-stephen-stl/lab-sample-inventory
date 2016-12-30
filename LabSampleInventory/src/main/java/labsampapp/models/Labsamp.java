package labsampapp.models;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="labsamps")
public class Labsamp {
	@Id
	private String id;
	
	@NotBlank
	@Size(max=250)
	@Indexed(unique=true)
	private String sampdescription;
	
	private Boolean completed = false;	
	private Date createdAt = new Date();
	private String sampleName;
	private String customerName;
	private String workflowName;
	private String barcode;
	private Date checkinDate;
	private String checkinPerson;
	private String status;
	private String instanceName;	
	private String testStatus;	
	private String batchId;	
	private String project;
	private Date startDate;
	private Date finishDate;
	private String results;
	private String shelfName;
			
	public Labsamp() {
		super();
	}
	
	public Labsamp(String sampdescription) {
		this.sampdescription = sampdescription;
	}	
	
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSampdescription() {
		return sampdescription;
	}

	public void setSampdescription(String sampdescription) {
		this.sampdescription = sampdescription;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getSampleName() {
		return sampleName;
	}

	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getWorkflowName() {
		return workflowName;
	}

	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Date getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}

	public String getCheckinPerson() {
		return checkinPerson;
	}

	public void setCheckinPerson(String checkinPerson) {
		this.checkinPerson = checkinPerson;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	public String getTestStatus() {
		return testStatus;
	}

	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public String getShelfName() {
		return shelfName;
	}

	public void setShelfName(String shelfName) {
		this.shelfName = shelfName;
	}
	@Override
    public String toString() {
        return String.format(
                "Labsamp[id=%s, sampdescription='%s', completed='%s', sampleName='%s', customerName='%s', workflowName='%s', "
                + "barcode='%s', checkinDate=%d, checkinPerson='%s', status='%s', instanceName=%s, testStatus='%s',"
                + " batchId='%s', project=%s, startDate='%d', finishDate='%d', results=%s, shelfName='%s']",
                id, sampdescription, completed, sampleName, customerName, workflowName, barcode, checkinDate, checkinPerson, 
                status, instanceName, testStatus, batchId, project, startDate, finishDate, results, shelfName);
    }	
}

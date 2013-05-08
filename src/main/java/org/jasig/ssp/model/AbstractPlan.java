/**
 * Licensed to Jasig under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Jasig licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jasig.ssp.model;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Immutable;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class AbstractPlan extends AbstractAuditable implements
		Cloneable {

	@Column(length = 200)
	@Size(max = 200)
	private String name;

	@Immutable
	@NotNull
	@ManyToOne()
	@JoinColumn(name = "owner_id", updatable = false, nullable = false)
	private Person owner;
	
	@Column(length = 200)
	@Size(max = 200)
	private String contactTitle;
	
	@Column(length = 200)
	@Size(max = 200)
	private String contactName;
	
	@Column(length = 200)
	@Size(max = 200)
	private String contactPhone;


	@Column(length = 200)
	@Size(max = 200)
	private String contactEmail;
	
	@Column(length = 2000)
	@Size(max = 2000)
	private String contactNotes;
	
	@Column(length = 2000)
	@Size(max = 2000)
	private String studentNotes;
	
	@Column(nullable = false)
	private Boolean isFinancialAid;

	@Column(nullable = false)
	private Boolean isImportant;
	
	@Column(name="is_f1_visa",nullable = false)
	private Boolean isF1Visa;	
	
	@Column(length = 2000)
	@Size(max = 2000)
	private String academicGoals;
	
	@Column(length = 2000)
	@Size(max = 2000)
	private String academicLink;
	
	@Column(length = 2000)
	@Size(max = 2000)
	private String careerLink;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected int hashPrime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	public String getContactTitle() {
		return contactTitle;
	}

	public void setContactTitle(String contactTitle) {
		this.contactTitle = contactTitle;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactNotes() {
		return contactNotes;
	}

	public void setContactNotes(String contactNotes) {
		this.contactNotes = contactNotes;
	}

	public String getStudentNotes() {
		return studentNotes;
	}

	public void setStudentNotes(String studentNotes) {
		this.studentNotes = studentNotes;
	}

	public Boolean getIsFinancialAid() {
		return isFinancialAid;
	}

	public void setIsFinancialAid(Boolean isFinancialAid) {
		this.isFinancialAid = isFinancialAid;
	}

	public Boolean getIsImportant() {
		return isImportant;
	}

	public void setIsImportant(Boolean isImportant) {
		this.isImportant = isImportant;
	}

	public Boolean getIsF1Visa() {
		return isF1Visa;
	}

	public void setIsF1Visa(Boolean isF1Visa) {
		this.isF1Visa = isF1Visa;
	}

	public String getAcademicGoals() {
		return academicGoals;
	}

	public void setAcademicGoals(String academicGoals) {
		this.academicGoals = academicGoals;
	}

	public String getAcademicLink() {
		return academicLink;
	}

	public void setAcademicLink(String academicLink) {
		this.academicLink = academicLink;
	}

	public String getCareerLink() {
		return careerLink;
	}

	public void setCareerLink(String careerLink) {
		this.careerLink = careerLink;
	}

}

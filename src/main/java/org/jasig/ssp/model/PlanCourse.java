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

import java.util.Comparator;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.jasig.ssp.model.TermCourses.TermCoursesTermDateComparator;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="map_plan_course")
public class PlanCourse extends AbstractPlanCourse<Plan> {

	
	private static final long serialVersionUID = -6316130725863888876L;

	@NotNull
	@ManyToOne()
	@JoinColumn(name = "plan_id", updatable = false, nullable = false)	
	private Plan plan;
	
	@NotNull
	@ManyToOne()
	@JoinColumn(name = "person_id", updatable = false, nullable = false)
	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	
	@Override
	protected PlanCourse clone() throws CloneNotSupportedException {
		PlanCourse clone = new PlanCourse();
		clone.setCourseCode(this.getCourseCode());
		clone.setCourseDescription(this.getCourseDescription());
		clone.setCourseTitle(this.getCourseTitle());
		clone.setCourseDescription(this.getCourseDescription());
		clone.setCreditHours(this.getCreditHours());
		clone.setFormattedCourse(this.getFormattedCourse());
		clone.setIsDev(this.isDev());
		clone.setOrderInTerm(this.getOrderInTerm());
		clone.setPerson(this.getPerson());
		clone.setTermCode(this.getTermCode());
		return clone;
	}

	@Override
	public Plan getParent() {
		return plan;
	}
}

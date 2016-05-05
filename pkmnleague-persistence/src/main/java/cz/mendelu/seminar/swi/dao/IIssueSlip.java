/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.dao;

import java.util.List;
import cz.mendelu.seminar.swi.domain.IssueSlipEntity;

/**
 * Data Access Object providing access to database operations for IssueSlip entity
 *
 * @author pirochta.jiri@gmail.com
 */
public interface IIssueSlip
{
    /**
     * Finds IssueSlip by given ID (primary key)
	 * @param id
	 * @return 
     */
    IssueSlipEntity findById(int id);

    /**
     * Saves IssueSlip entity to database, can either update existing IssueSlip or save new one
	 * @param issueSlip
     */
    void save(IssueSlipEntity issueSlip);

    /**
     * Deletes given entity from database
	 * @param issueSlip
     */
    void delete(IssueSlipEntity issueSlip);

    /**
     * Returns all existing IssueSlip entities in database
	 * @return 
     */
    List<IssueSlipEntity> findAll();
}

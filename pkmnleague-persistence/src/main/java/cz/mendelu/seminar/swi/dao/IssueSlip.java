/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.dao;

import cz.mendelu.seminar.swi.dao.IIssueSlip;
import cz.mendelu.seminar.swi.domain.IssueSlipEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import cz.mendelu.seminar.swi.utils.DaoLayerException;

/**
 *
 * @author pirochta.jiri@gmail.com
 */
@Repository
public class IssueSlip implements IIssueSlip {

    @PersistenceContext
    private EntityManager entityManager;

	@Override
	public IssueSlipEntity findById(int id)
	{
        try {
            return entityManager.find(IssueSlipEntity.class, id);
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
	}

	@Override
    public void save(IssueSlipEntity issueSlip) {
        if (findById(issueSlip.getId_issueSlip()) != null) {
            try {
                entityManager.merge(issueSlip);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        } else {
            try {
                entityManager.persist(issueSlip);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        }
    }

	@Override
	public void delete(IssueSlipEntity issueSlip) {
        try {
            entityManager.remove(findById(issueSlip.getId_issueSlip()));
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }

	@Override
	public List<IssueSlipEntity> findAll(){
        try {
            return entityManager.createQuery("select c from IssueSlipEntity c", IssueSlipEntity.class).getResultList();
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }
}

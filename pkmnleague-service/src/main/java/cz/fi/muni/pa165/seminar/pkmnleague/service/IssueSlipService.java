package cz.fi.muni.pa165.seminar.pkmnleague.service;


import cz.mendelu.seminar.swi.domain.IssueSlipEntity;

import java.util.List;

/**
 * An interface that defines a service access to the {@link Badge} entity.
 *
 * @author Pavel Kouřil <pk@pavelkouril.cz>
 */
public interface IssueSlipService {

    void save(IssueSlipEntity issueSlip);

    IssueSlipEntity findById(int id);

    List<IssueSlipEntity> findAll();

    void delete(IssueSlipEntity issueSlip);

   
}

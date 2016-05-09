package cz.fi.muni.pa165.seminar.pkmnleague.service;

import cz.fi.muni.pa165.seminar.pkmnleague.exceptions.PokemonLeagueServiceException;
import cz.mendelu.seminar.swi.dao.IssueSlip;
import cz.mendelu.seminar.swi.domain.IssueSlipEntity;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


/**
 * @author dhanak @domhanak on 11/25/15.
 */
@Service
public class IssueSlipServiceImpl implements IssueSlipService {

    @Inject
    private IssueSlip issueSlip;

    @Override
    public void save(IssueSlipEntity isEnt) {
        issueSlip.save(isEnt);
    }

    @Override
    public IssueSlipEntity findById(int id) {
        return issueSlip.findById(id);
    }

    @Override
    public List<IssueSlipEntity> findAll() {
        return issueSlip.findAll();
    }

    @Override
    public void delete(IssueSlipEntity isEnt) {
        issueSlip.delete(isEnt);
    }
  
}

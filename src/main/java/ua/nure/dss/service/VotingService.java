package ua.nure.dss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.nure.dss.domain.Alternative;
import ua.nure.dss.domain.Lpr;
import ua.nure.dss.domain.VotingRes;
import ua.nure.dss.repository.AlternativeRepository;
import ua.nure.dss.repository.LprRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Ihor_Prokopov
 */
@Service
public class VotingService {

    @Autowired
    private LprRepository lprRepository;

    @Autowired
    private AlternativeRepository alternativeRepository;

    public VotingRes calculateByBord() {
        List<Lpr> lprs = lprRepository.findAll();
        List<Alternative> alts = alternativeRepository.findAll();
        VotingRes votingRes = new VotingRes();
        Map<Alternative, Integer> marks = alts.stream().collect(Collectors.toMap(a -> a, a -> 0));
        for (Lpr lpr : lprs) {
            Collections.shuffle(alts);
            Map<Alternative, Integer> points = new HashMap<>();
            for (int x = 0; x < alts.size(); x++) {
                points.put(alts.get(x), x + 1);
                marks.put(alts.get(x), marks.get(alts.get(x)) + x + 1);
            }
            votingRes.putVotingRes(lpr, points);
        }
        votingRes.setWinner(marks.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey());
        votingRes.setPoints(marks.get(votingRes.getWinner()));
        votingRes.setTotalRes(marks);
        return votingRes;
    }

    public VotingRes calculateByKondorse() {
        List<Lpr> lprs = lprRepository.findAll();
        List<Alternative> alts = alternativeRepository.findAll();
        Map<Lpr, List<Alternative>> voting = new HashMap<>();
        for (Lpr lpr : lprs) {
            Collections.shuffle(alts);
            voting.put(lpr, new ArrayList<>(alts));
        }

        Alternative bestAlt = alts.get(0);
        for (int x = 1; x < alts.size(); x++) {
            int compareRes = compare(voting, bestAlt, alts.get(x));
            if (compareRes > 0){
                continue;
            }else if (compareRes < 0){
                bestAlt = alts.get(x);
            }
        }
        VotingRes res = new VotingRes();
        res.setWinner(bestAlt);
        res.setKondorseVotingRes(voting);
        return res;
    }

    private int compare(Map<Lpr, List<Alternative>> voting, Alternative alt1, Alternative alt2) {
        int res = 0;
        for (Map.Entry<Lpr, List<Alternative>> entry : voting.entrySet()) {
            for (Alternative alt : entry.getValue()) {
                if (alt.equals(alt1)) {
                    res++;
                    break;
                }
                if (alt.equals(alt2)) {
                    res--;
                    break;
                }
            }
        }
        return res;
    }


}

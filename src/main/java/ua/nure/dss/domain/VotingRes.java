/*
 * Canadian Tire Corporation, Ltd. Do not reproduce without permission in writing.
 * Copyright (c) 2016 Canadian Tire Corporation, Ltd. All rights reserved.
 */

package ua.nure.dss.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ihor_Prokopov
 */
public class VotingRes {

    private Map<Lpr, Map<Alternative, Integer>> votingRes;
    Map<Lpr, List<Alternative>> kondorseVotingRes;
    private Map<Alternative, Integer> totalRes;
    private Alternative winner;
    private Integer points;

    public VotingRes(Map<Lpr, Map<Alternative, Integer>> votingRes) {
        this.votingRes = votingRes;
    }

    public VotingRes() {
        votingRes = new HashMap<>();
    }

    public void putVotingRes(Lpr lpr, Map<Alternative, Integer> res){
        votingRes.put(lpr, res);
    }

    public Map<Lpr, Map<Alternative, Integer>> getVotingRes() {
        return votingRes;
    }

    public void setVotingRes(Map<Lpr, Map<Alternative, Integer>> votingRes) {
        this.votingRes = votingRes;
    }

    public Alternative getWinner() {
        return winner;
    }

    public void setWinner(Alternative winner) {
        this.winner = winner;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "VotingRes{" +
               "votingRes=" + votingRes +
               ", winner=" + winner.getName() +
               ", points=" + points +
               '}';
    }

    public Map<Alternative, Integer> getTotalRes() {
        return totalRes;
    }

    public void setTotalRes(Map<Alternative, Integer> totalRes) {
        this.totalRes = totalRes;
    }

    public Map<Lpr, List<Alternative>> getKondorseVotingRes() {
        return kondorseVotingRes;
    }

    public void setKondorseVotingRes(Map<Lpr, List<Alternative>> kondorseVotingRes) {
        this.kondorseVotingRes = kondorseVotingRes;
    }
}

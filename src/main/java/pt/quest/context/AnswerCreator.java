package pt.quest.context;

import pt.quest.entity.Answer;

import java.util.Objects;


public class AnswerCreator{

    private static final String ACCEPT_CALL = "I'm gonna accept the call.";
    private static final String NOT_ACCEPT_CALL = "I'm gonna refuse the call.";
    private static final String GO_TO_CAPTAIN = "I'm going up to the Captain's bridge.";
    private static final String NOT_GO_TO_CAPTAIN = "I'm not going up to the bridge.";
    private static final String TELL_TRUTH = "I'm gonna tell the truth.";
    private static final String TELL_LIES = "I'm gonna tell lies about myself.";


    private final Answer acceptCall = new Answer(ACCEPT_CALL, 2);
    private final Answer notAcceptCall = new Answer(NOT_ACCEPT_CALL, 11);
    private final Answer goToCaptain = new Answer(GO_TO_CAPTAIN, 3);
    private final Answer notGoToCaptain = new Answer(NOT_GO_TO_CAPTAIN, 22);
    private final Answer tellTruth = new Answer(TELL_TRUTH, 4);
    private final Answer tellLies = new Answer(TELL_LIES, 33);


    public Answer getAcceptCall() {
        return acceptCall;
    }

    public Answer getNotAcceptCall() {
        return notAcceptCall;
    }

    public Answer getGoToCaptain() {
        return goToCaptain;
    }

    public Answer getNotGoToCaptain() {
        return notGoToCaptain;
    }

    public Answer getTellTruth() {
        return tellTruth;
    }

    public Answer getTellLies() {
        return tellLies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerCreator that = (AnswerCreator) o;
        return Objects.equals(acceptCall, that.acceptCall) &&
                Objects.equals(notAcceptCall, that.notAcceptCall) &&
                Objects.equals(goToCaptain, that.goToCaptain) &&
                Objects.equals(notGoToCaptain, that.notGoToCaptain) &&
                Objects.equals(tellTruth, that.tellTruth) &&
                Objects.equals(tellLies, that.tellLies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acceptCall, notAcceptCall, goToCaptain, notGoToCaptain, tellTruth, tellLies);
    }

    @Override
    public String toString() {
        return "AnswerCreator{" +
                "acceptCall=" + acceptCall +
                ", notAcceptCall=" + notAcceptCall +
                ", goToCaptain=" + goToCaptain +
                ", notGoToCaptain=" + notGoToCaptain +
                ", tellTruth=" + tellTruth +
                ", tellLies=" + tellLies +
                '}';
    }
}

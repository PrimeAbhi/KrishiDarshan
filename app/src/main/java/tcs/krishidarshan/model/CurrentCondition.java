package tcs.krishidarshan.model;

import com.google.gson.annotations.SerializedName;

public class CurrentCondition {

    @SerializedName("metadata")
    private Metadata metadata = null;
    @SerializedName("observation")
    private Observation observation = null;

    /**
     **/
    public Metadata getMetadata() {

        return metadata;
    }

    public void setMetadata(Metadata metadata) {

        this.metadata = metadata;
    }

    /**
     **/
    public Observation getObservation() {

        return observation;
    }

    public void setObservation(Observation observation) {

        this.observation = observation;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CurrentCondition {\n");

        sb.append("  metadata: ").append(metadata).append("\n");
        sb.append("  observation: ").append(observation).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}

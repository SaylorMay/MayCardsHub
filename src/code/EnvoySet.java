package code;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({
        "_type",
        "timestamp",
        "version",
        "data"
})

public class EnvoySet {
    // Line 2
    public String _type = "";

    // Line 3
    public long timestamp = 0;

    // Line 4
    public String version = "";

    // Line 3
    public List<EnvoyCard> data = new ArrayList<EnvoyCard>();

    public EnvoySet() {
        _type = "tcg-deck-builder-export";
        timestamp = 1781323511710L;
        version = "1.0";
    }

    public EnvoySet(List<EnvoyCard> data, long timestamp, String version) {
        this.data = data;
        _type = "tcg-deck-builder-export";
        timestamp = 1781323511710L;
        version = "1.0";
    }
}
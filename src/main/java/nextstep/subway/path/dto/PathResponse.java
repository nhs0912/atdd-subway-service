package nextstep.subway.path.dto;

import nextstep.subway.line.domain.Distance;
import nextstep.subway.station.domain.Station;
import nextstep.subway.station.dto.StationResponse;

import java.util.List;
import java.util.stream.Collectors;

public class PathResponse {

    private List<StationResponse> stations;
    private Distance distance;

    protected PathResponse() {

    }

    public PathResponse(List<StationResponse> stations, Distance distance) {
        this.stations = stations;
        this.distance = distance;
    }

    public static PathResponse of(List<Station> stations, Distance distance) {
        List<StationResponse> stationResponses = stations.stream()
                .map(it -> StationResponse.of(it))
                .collect(Collectors.toList());

        return new PathResponse(stationResponses, distance);
    }

    public List<StationResponse> getStations() {
        return stations;
    }

    public int getDistance() {
        return distance.distance();
    }
}

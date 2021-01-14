package uk.co.stringerj.tidetimes.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import uk.co.stringerj.tidetimes.model.Station;
import uk.co.stringerj.tidetimes.service.TideTimesService;

public class TideTimesControllerTest {

  @Mock private TideTimesService service;

  private TideTimesController testSubject;

  @Test
  public void testGetStations() throws Exception {
    List<Station> stations =
        Arrays.asList(new Station("1", "2", "StationA"), new Station("3", "4", "StationB"));
    when(service.getStations()).thenReturn(stations);
    assertThat(testSubject.getStations(), equalTo(stations));
  }

  @Test
  public void testGetStation() throws Exception {
    Station station = new Station("5", "6", "StationC");
    when(service.getStation("StationC")).thenReturn(station);
    assertThat(testSubject.getStation("StationC"), equalTo(station));
  }

  @BeforeEach
  public void setup() throws Exception {
    initMocks(this);
    testSubject = new TideTimesController(service);
  }
}

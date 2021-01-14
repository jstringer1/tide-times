(function() {
	function loadStations() {
		var req = new XMLHttpRequest();
		req.onreadystatechange = function() {
			if(req.readyState == 4) {
				setStations( JSON.parse( req.responseText ) );
			}
		}
		req.open("GET", "./stations");
		req.send();
	}
	
	function setStations( stations ) {
		var stationsSelect = document.getElementById("stations");
		for(var i=0; i<stations.length; i++) {
			var option = document.createElement( "option" );
			option.textContent = stations[i].name;
			option.value = JSON.stringify( stations[i] );
			stationsSelect.appendChild( option );
			if(option.textContent == "HOLYHEAD") {
				stationsSelect.selectedIndex = i;
			}
		}
		stationsSelect.addEventListener('change', (event) => {
			selectStation( JSON.parse( stationsSelect.value ) );
		});
		selectStation( JSON.parse( stationsSelect.value ) );
	}
	
	function selectStation( station ) {
		console.log(station);
		var req = new XMLHttpRequest();
		req.onreadystatechange = function() {
			if(req.readyState == 4) {
				updatePredictions( station, JSON.parse( req.responseText ) );
			}
		}
		req.open("GET", "./station/"+station.name+"/predictions");
		req.send();
	}
	
	function updatePredictions( station, predictions ) {
		drawTideChart( station, predictions );
	}
	
	function drawTideChart( station, predictions ) {
		var rawData = [ [ 'Time', 'Tide Height' ] ];
		for(var i=0; i<12; i++) {
			var dateTime = new Date( predictions[i].dateTime );
			rawData.push([ formatDateTimeForChart( dateTime ), predictions[i].height ]);
		}
		var data = google.visualization.arrayToDataTable( rawData );
        var options = {
          interpolateNulls: true,
          curveType: 'function',
          legend: { position: 'none' }
        };
        var chart = new google.visualization.LineChart( document.getElementById( 'chart' ) );
        chart.draw( data, options );
	}
	
	function formatDateTimeForChart( dateTime ) {
		var day = ['Sun','Mon','Tue','Wed','Thu','Fri','Sat'];
		var dayStr = day[ dateTime.getDay() ];
		var hourStr = ("0" + dateTime.getHours()).slice(-2);
		var minStr = ("0" + dateTime.getMinutes()).slice(-2);
		return dayStr + ' ' + hourStr + ':' + minStr;
	}
	
	google.charts.load('current', {'packages':['corechart']});
	google.setOnLoadCallback(loadStations);
})();
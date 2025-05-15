import { MapContainer, TileLayer, CircleMarker, Popup } from "react-leaflet";
import "leaflet/dist/leaflet.css";

function IndiaMap() {
    const parks = [
        { name: "Jim Corbett", count: 4, coords: [29.5300, 78.7747] },
        { name: "Ranthambore", count: 2, coords: [26.0173, 76.5026] },
        { name: "Bandipur", count: 1, coords: [11.6591, 76.6516] },
        { name: "Kaziranga", count: 0, coords: [26.5775, 93.1711] } // Hidden if count 0
    ];

    // Function to get color based on tiger count
    const getColor = (count) => {
        if (count >= 10) return "#8B0000"; // Dark Red
        if (count >= 5) return "#FF4500"; // Orange Red
        if (count >= 2) return "#FFA500"; // Orange
        return "#FFFF00"; // Yellow
    };

    return (
        <div className="w-full h-[450px] max-w-3xl rounded-lg shadow-lg overflow-hidden">
            <MapContainer
                zoom={4.2} 
                center={[22.5, 79]}
                style={{ width: "100%", height: "100%" }}
                scrollWheelZoom={false}
            >
                <TileLayer
                    url="https://{s}.basemaps.cartocdn.com/light_all/{z}/{x}/{y}{r}.png"
                    attribution="&copy; OpenStreetMap contributors &copy; CARTO"
                />
                {parks.map(
                    (park, index) =>
                        park.count > 0 && (
                            <CircleMarker
                                key={index}
                                center={park.coords}
                                radius={10} // Fixed radius, or vary if you want by count
                                fillColor={getColor(park.count)}
                                color={getColor(park.count)}
                                weight={1}
                                fillOpacity={0.8}
                            >
                                <Popup>
                                    {park.name} <br /> Tigers Sighted: {park.count}
                                </Popup>
                            </CircleMarker>
                        )
                )}
            </MapContainer>
        </div>
    );
}

export default IndiaMap;

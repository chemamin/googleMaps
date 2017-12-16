package android.csulb.edu.googlemaps;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;







public class MapsActivity extends Activity implements OnMapReadyCallback{
    private final LatLng LOCATION_UNIV = new LatLng(33.783768 , -118.114336);
    private final LatLng LOCATION_ECS = new LatLng(33.782777, -118.111868);
    private GoogleMap map;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        MapFragment mapF = ((MapFragment) getFragmentManager().findFragmentById(R.id.map));
        mapF.getMapAsync(this);
        map.addMarker(new MarkerOptions().position(LOCATION_ECS).title("Find Me Here!"));
    }

    public void onClick_ECS(View v){
        map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_UNIV, 14);
        map.animateCamera(update);
    }

    public void onCLick_LongBeach(View v){
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_ECS, 16);
        map.animateCamera(update);
    }

    public void onClick_City(View v){
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_UNIV, 9);
        map.animateCamera(update);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map.addMarker(new MarkerOptions()
        .position(new LatLng(0,0))
        .title("Marker"));
    }
}

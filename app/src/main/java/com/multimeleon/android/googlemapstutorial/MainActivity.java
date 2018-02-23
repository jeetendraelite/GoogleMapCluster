package com.multimeleon.android.googlemapstutorial;

import android.content.Context;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;
import com.multimeleon.android.googlemapstutorial.Model.Person;

public class MainActivity extends BaseGoogleMapsActivity {
    
    private ClusterManager<Person> mClusterManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        setupMap(googleMap);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(23.0506004, 72.600665), 15));

        mClusterManager = new ClusterManager<>(this, googleMap);

        googleMap.setOnCameraIdleListener(mClusterManager);
        googleMap.setOnMarkerClickListener(mClusterManager);
        googleMap.setOnInfoWindowClickListener(mClusterManager);
        addPersonItems(googleMap);

    }
//23.0941395,72.6122042
    private void addPersonItems(GoogleMap googleMap) {

     //   mClusterManager = new ClusterManager<>(this, googleMap);

      //  for (int i = 0; i < 4; i++)
        {
            mClusterManager.addItem(new Person(23.0506004, 72.600665, "SBI Civil Branch", "https://twitter.com/pjapplez"));
            mClusterManager.addItem(new Person(23.0734, 72.6266, "Ahme airport", "https://twitter.com/pjapplez"));
            mClusterManager.addItem(new Person(23.0273, 72.6008, "Railway Station", "https://twitter.com/pjapplez"));

            mClusterManager.addItem(new Person(23.0858, 72.6296, "Indira Bridge", "https://twitter.com/pjapplez"));


         mClusterManager.addItem(new Person(23.0506024, 72.600665, "SBI Civil Branch", "https://twitter.com/pjapplez"));
            mClusterManager.addItem(new Person(23.0134, 72.6266, "Ahme airport", "https://twitter.com/pjapplez"));
            mClusterManager.addItem(new Person(23.0293, 72.6008, "Railway Station", "https://twitter.com/pjapplez"));

            mClusterManager.addItem(new Person(23.1858, 72.6296, "Indira Bridge", "https://twitter.com/pjapplez"));
          //  mClusterManager.addItem(new Person(23.0941395, 72.6122042, "Koteshwar Temple Motera", "https://twitter.com/pjapplez"));
        }

        mClusterManager.cluster();
    }

    private class RenderClusterInfoWindow extends DefaultClusterRenderer<Person> {

        RenderClusterInfoWindow(Context context, GoogleMap map, ClusterManager<Person> clusterManager) {
            super(context, map, clusterManager);
        }

        @Override
        protected void onClusterRendered(Cluster<Person> cluster, Marker marker) {
            super.onClusterRendered(cluster, marker);
        }

        @Override
        protected void onBeforeClusterItemRendered(Person item, MarkerOptions markerOptions) {
            markerOptions.title(item.getName());

            super.onBeforeClusterItemRendered(item, markerOptions);
        }
    }
}

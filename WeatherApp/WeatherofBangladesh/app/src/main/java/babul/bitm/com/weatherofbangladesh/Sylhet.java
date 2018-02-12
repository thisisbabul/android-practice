package babul.bitm.com.weatherofbangladesh;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class Sylhet extends AppCompatActivity {
    private final static String urlSylhet = "http://api.openweathermap.org/data/2.5/weather?q=Sylhet,bd&appid=2de143494c0b295cca9337e1e96b00e0";
    private TextView tvError, tvDivision, tvDate, tvDescription, tvIcon, tvTemperature,tvPressureIcon, tvPressureM,
            tvHumidityIcon, tvHumidityM, tvTempMaxIcon, tvTempMaxM, tvTempMinIcon, tvTempMinM, tvSunriseIcon, tvSunriseM,
            tvSunsetIcon, tvSunsetM, tvWindSeepIcon, tvWinSpeedM, tvSeaLevelIcon, tvSeaLevelM, tvGrandLevelIcon,tvGandLevelM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sylhet);
        tvError= (TextView) findViewById(R.id.tvSylhetError);
        tvDivision= (TextView) findViewById(R.id.tvSylhetDivisiond);
        tvDate= (TextView) findViewById(R.id.tvSylhetDate);
        tvDescription= (TextView) findViewById(R.id.tvSylhetDescriptionn);


        //tvIcon= (TextView) findViewById(R.id.LDhakaIcon);
        tvTemperature= (TextView) findViewById(R.id.tvSylhetTemperaturet);
        tvPressureIcon= (TextView) findViewById(R.id.tvPressureIcon);
        tvPressureM= (TextView) findViewById(R.id.tvPressureM);
        tvHumidityIcon= (TextView) findViewById(R.id.tvHumidityIcon);
        tvHumidityM= (TextView) findViewById(R.id.tvHumidityM);
        tvTempMaxIcon= (TextView) findViewById(R.id.tvTempMaxIcom);
        tvTempMaxM= (TextView) findViewById(R.id.tvTemMaxM);
        tvTempMinIcon= (TextView) findViewById(R.id.tvTempMinIcon);
        tvTempMinM= (TextView) findViewById(R.id.tvTemMinM);
        tvSunriseIcon= (TextView) findViewById(R.id.tvSunriseIcon);
        tvSunriseM= (TextView) findViewById(R.id.tvSunriseM);
        tvSunsetIcon= (TextView) findViewById(R.id.tvSunsetIcon);
        tvSunsetM= (TextView) findViewById(R.id.tvSunsetM);
        tvWindSeepIcon= (TextView) findViewById(R.id.tvWindSeepIcon);
        tvWinSpeedM= (TextView) findViewById(R.id.tvWindSeepM);
        tvSeaLevelIcon= (TextView) findViewById(R.id.tvSeaLevelIcon);
        tvSeaLevelM= (TextView) findViewById(R.id.tvSeaLevelM);
        tvGrandLevelIcon= (TextView) findViewById(R.id.tvGrandLevelIcon);
        tvGandLevelM= (TextView) findViewById(R.id.tvGrandLevelM);
        SylhetMethod();
    }

    public void SylhetMethod() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlSylhet, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray weather = response.getJSONArray("weather");
                    JSONObject jsonObject = weather.getJSONObject(0);
                    JSONObject tempObject = response.getJSONObject("main");
                    JSONObject countryObject = response.getJSONObject("sys");
                    JSONObject windObject = response.getJSONObject("wind");


                    String description = jsonObject.getString("description");
                    String icon = jsonObject.getString("icon");
                    String kalvintemperature = tempObject.getString("temp");
                    double dubTemp=Double.parseDouble(kalvintemperature)-273;
                    int intTemp=(int)dubTemp;
                    String temperature=String.valueOf(intTemp);
                    String division = response.getString("name");
                    String sunrisen = countryObject.getString("sunrise");
                    int milliseconds=Integer.parseInt(sunrisen);
                    int seconds = (int) (milliseconds / 1000) % 60 ;
                    int minutes = (int) ((milliseconds / (1000*60)) % 60);
                    int hours   = ((int) ((milliseconds / (1000*60*60)) % 24))-13;
                    String sunrise=hours+":"+minutes+":"+seconds;


                    String sunsets = countryObject.getString("sunset");
                    int millisecondss=Integer.parseInt(sunsets);
                    int secondss = (int) (millisecondss / 1000) % 60 ;
                    int minutess = (int) ((millisecondss / (1000*60)) % 60);
                    int hourss   = (int) ((millisecondss / (1000*60*60)) % 24);
                    String sunset=hourss+":"+minutess+":"+secondss;

                    String pressuree = tempObject.getString("pressure");

                    double dubpressure=Double.parseDouble(pressuree)/10;
                    int intpressure=(int)dubpressure;
                    String pressure=String.valueOf(intpressure);

                    String humidity = tempObject.getString("humidity");
                    String tempMax = tempObject.getString("temp_max");
                    double dubTempMx=Double.parseDouble(tempMax)-273;
                    int intTempMx=(int)dubTempMx;
                    String tempMaxF=String.valueOf(intTempMx);



                    String tempMin = tempObject.getString("temp_min");

                    double dubTempMn=Double.parseDouble(tempMin)-273;
                    int intTempMn=(int)dubTempMn;
                    String tempMinF=String.valueOf(intTempMn);

                    String windspeed=windObject.getString("speed");
                    String seaLevell = tempObject.getString("sea_level");

                    double dubsea=Double.parseDouble(seaLevell)/40;
                    int intsea=(int)dubsea;
                    String seaLevel=String.valueOf(intsea);

                    String grandLevell = tempObject.getString("grnd_level");

                    double dubgrand=Double.parseDouble(grandLevell)/40;
                    int intgnd=(int)dubgrand;
                    String grandLevel=String.valueOf(intgnd);

                    tvDivision.setText(division);
                    tvDescription.setText(description);
                    tvTemperature.setText(temperature+"℃");
                    tvPressureM.setText(pressure+"kPa");
                    tvHumidityM.setText(humidity+"%");
                    tvTempMaxM.setText(tempMaxF+"℃");
                    tvTempMinM.setText(tempMinF+"℃");
                    tvSunriseM.setText(sunrise);
                    tvSunsetM.setText(sunset);
                    tvWinSpeedM.setText(windspeed+"km/h");
                    tvSeaLevelM.setText(seaLevel+" meter");
                    tvGandLevelM.setText(grandLevel+" meter");


                    Date date = new Date();
                    String currentdate=String.valueOf(date);
                    tvDate.setText(currentdate);





                    if (icon.equals("01d")){

                        LinearLayout ll= (LinearLayout) findViewById(R.id.LSylhetIcon);
                        ll.setBackgroundResource(R.drawable.skyisclear);

                    }

                    else if (icon.equals("02d")){

                        LinearLayout ll= (LinearLayout) findViewById(R.id.LSylhetIcon);
                        ll.setBackgroundResource(R.drawable.fewclouds);

                    }

                    else if (icon.equals("03d")){

                        LinearLayout ll= (LinearLayout) findViewById(R.id.LSylhetIcon);
                        ll.setBackgroundResource(R.drawable.scatteredclouds);

                    }

                    else if (icon.equals("04d")){

                        LinearLayout ll= (LinearLayout) findViewById(R.id.LSylhetIcon);
                        ll.setBackgroundResource(R.drawable.brokenclouds);
                    }

                    else if (icon.equals("09d")){

                        LinearLayout ll= (LinearLayout) findViewById(R.id.LSylhetIcon);
                        ll.setBackgroundResource(R.drawable.showerrain);

                    }

                    else if (icon.equals("10d")){

                        LinearLayout ll= (LinearLayout) findViewById(R.id.LSylhetIcon);
                        ll.setBackgroundResource(R.drawable.rain);

                    }

                    else if (icon.equals("11d")){

                        LinearLayout ll= (LinearLayout) findViewById(R.id.LSylhetIcon);
                        ll.setBackgroundResource(R.drawable.thunderstorm);

                    }

                    else if (icon.equals("13d")){

                        LinearLayout ll= (LinearLayout) findViewById(R.id.LSylhetIcon);
                        ll.setBackgroundResource(R.drawable.snow);

                    }

                    else if (icon.equals("50d")){

                        LinearLayout ll= (LinearLayout) findViewById(R.id.LSylhetIcon);
                        ll.setBackgroundResource(R.drawable.mist);

                    }
                    else {
                        LinearLayout ll= (LinearLayout) findViewById(R.id.LSylhetIcon);
                        ll.setBackgroundResource(R.drawable.skyisclear);
                    }



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tvError.setText("Please connect internet in your device");

            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjectRequest);


    }

}

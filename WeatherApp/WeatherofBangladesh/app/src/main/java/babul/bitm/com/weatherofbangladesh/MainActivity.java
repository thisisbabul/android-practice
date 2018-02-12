package babul.bitm.com.weatherofbangladesh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private final static String urlDhaka = "http://api.openweathermap.org/data/2.5/weather?q=Dhaka,bd&appid=2de143494c0b295cca9337e1e96b00e0";
    private final static String urlMymensingh="http://api.openweathermap.org/data/2.5/weather?q=Mymensingh,bd&appid=2de143494c0b295cca9337e1e96b00e0";
    private final static String urlChittagong="http://api.openweathermap.org/data/2.5/weather?q=Chittagong,bd&appid=2de143494c0b295cca9337e1e96b00e0";
    private final static String urlSylhet="http://api.openweathermap.org/data/2.5/weather?q=Sylhet,bd&appid=2de143494c0b295cca9337e1e96b00e0";
    private final static String urlRangpur="http://api.openweathermap.org/data/2.5/weather?q=Rangpur,bd&appid=2de143494c0b295cca9337e1e96b00e0";
    private final static String urlRajshahi="http://api.openweathermap.org/data/2.5/weather?q=Rajshahi,bd&appid=2de143494c0b295cca9337e1e96b00e0";
    private final static String urlKhulna="http://api.openweathermap.org/data/2.5/weather?q=Khulna,bd&appid=2de143494c0b295cca9337e1e96b00e0";
    private final static String urlBarisal="http://api.openweathermap.org/data/2.5/weather?q=Barisal,bd&appid=2de143494c0b295cca9337e1e96b00e0";
    private TextView tvDhakaTemperature, tvDhakaDivision, tvDhakaTime, tvDhakaCountry, tvError;
    private TextView tvMymensinghTemperature, tvMymensinghDivision, tvMymensinghTime, tvMymensinghCountry;
    private TextView tvChittagongTemperature, tvChittagongDivision, tvChittagongTime, tvChittagongCountry;
    private TextView tvSylhetTemperature, tvSylhetDivision, tvSylhetTime, tvSylhetCountry;
    private TextView tvRangpurTemperature, tvRangpurDivision, tvRangpurTime, tvRangpurCountry;
    private TextView tvRajshahiTemperature, tvRajshahiDivision, tvRajshahiTime, tvRajshahiCountry;
    private TextView tvKhulnaTemperature, tvKhulnaDivision, tvKhulnaTime, tvKhulnaCountry;
    private TextView tvBarisalTemperature, tvBarisalDivision, tvBarisalTime, tvBarisalCountry;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDhakaTemperature= (TextView) findViewById(R.id.tvDhakaTemperature);
        tvDhakaDivision= (TextView) findViewById(R.id.tvDhakaDivision);
        tvDhakaTime= (TextView) findViewById(R.id.tvDhakaTime);
        tvDhakaCountry= (TextView) findViewById(R.id.tvDhakaCountry);
        tvError= (TextView) findViewById(R.id.tvError);
        dhakaMethod();

        tvMymensinghTemperature= (TextView) findViewById(R.id.tvMymensinghTemperature);
        tvMymensinghDivision= (TextView) findViewById(R.id.tvMymensinghDivision);
        tvMymensinghTime= (TextView) findViewById(R.id.tvMymensinghTime);
        tvMymensinghCountry= (TextView) findViewById(R.id.tvMymensinghCountry);
        mymensinghMethod();

        tvChittagongTemperature= (TextView) findViewById(R.id.tvChittagongTemperature);
        tvChittagongDivision= (TextView) findViewById(R.id.tvChittagongDivision);
        tvChittagongTime= (TextView) findViewById(R.id.tvChittagongTime);
        tvChittagongCountry= (TextView) findViewById(R.id.tvChittagongCountry);
        chittagongMethod();

        tvSylhetTemperature= (TextView) findViewById(R.id.tvSylhetTemperature);
        tvSylhetDivision= (TextView) findViewById(R.id.tvSylhetDivision);
        tvSylhetTime= (TextView) findViewById(R.id.tvSylhetTime);
        tvSylhetCountry= (TextView) findViewById(R.id.tvSylhetCountry);
        sylhetMethod();

        tvRangpurTemperature= (TextView) findViewById(R.id.tvRangpurTemperature);
        tvRangpurDivision= (TextView) findViewById(R.id.tvRangpurDivision);
        tvRangpurTime= (TextView) findViewById(R.id.tvRangpurTime);
        tvRangpurCountry= (TextView) findViewById(R.id.tvRangpurCountry);
        rangpurMethod();

        tvRajshahiTemperature= (TextView) findViewById(R.id.tvRajshahiTemperature);
        tvRajshahiDivision= (TextView) findViewById(R.id.tvRajshahiDivision);
        tvRajshahiTime= (TextView) findViewById(R.id.tvRajshahiTime);
        tvRajshahiCountry= (TextView) findViewById(R.id.tvRajshahiCountry);
        rajshahiMethod();

        tvKhulnaTemperature= (TextView) findViewById(R.id.tvKhulnaTemperature);
        tvKhulnaDivision= (TextView) findViewById(R.id.tvKhulnaDivision);
        tvKhulnaTime= (TextView) findViewById(R.id.tvKhulnaTime);
        tvKhulnaCountry= (TextView) findViewById(R.id.tvKhulnaCountry);
        khulnaMethod();

        tvBarisalTemperature= (TextView) findViewById(R.id.tvBarisalTemperature);
        tvBarisalDivision= (TextView) findViewById(R.id.tvBarisalDivision);
        tvBarisalTime= (TextView) findViewById(R.id.tvBarisalTime);
        tvBarisalCountry= (TextView) findViewById(R.id.tvBarisalCountry);
        barisalMethod();
    }

    public void dhakaMethod() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlDhaka, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray weather = response.getJSONArray("weather");
                    JSONObject jsonObject = weather.getJSONObject(0);
                    JSONObject tempObject = response.getJSONObject("main");
                    JSONObject countryObject = response.getJSONObject("sys");


                    //String description = jsonObject.getString("description");
                    String icon = jsonObject.getString("icon");
                    String kalvintemperature = tempObject.getString("temp");
                    double dubTemp=Double.parseDouble(kalvintemperature)-273;
                    int intTemp=(int)dubTemp;
                    String temperature=String.valueOf(intTemp);
                    String division = response.getString("name");
                    String countryJson = countryObject.getString("country");

                    Date date = new Date();

                    String strHour = "hh";
                    SimpleDateFormat hour = new SimpleDateFormat(strHour);
                    String Hour = hour.format(date);
                    String strMin = "mm";
                    SimpleDateFormat min = new SimpleDateFormat(strMin);
                    String Minutes = min.format(date);
                    String time = Hour + " : " + Minutes;


                    if (countryJson.equals("BD")) {
                        String country = "Bangladesh";
                        tvDhakaCountry.setText(country);
                    }else {

                    }
                    tvDhakaTemperature.setText(temperature+"℃");
                    tvDhakaDivision.setText(division);
                    tvDhakaTime.setText(time);



                    if (icon.equals("01d")){

                        String urlDhaka="http://openweathermap.org/img/w/01d.png";
                        WebView wvDhaka= (WebView) findViewById(R.id.wvDhaka);
                        wvDhaka.getSettings().setJavaScriptEnabled(true);
                        wvDhaka.loadUrl(urlDhaka);

                    }

                    else if (icon.equals("02d")){

                        String urlDhaka="http://openweathermap.org/img/w/02d.png";
                        WebView wvDhaka= (WebView) findViewById(R.id.wvDhaka);
                        wvDhaka.getSettings().setJavaScriptEnabled(true);
                        wvDhaka.loadUrl(urlDhaka);

                    }

                    else if (icon.equals("03d")){

                        String urlDhaka="http://openweathermap.org/img/w/03d.png";
                        WebView wvDhaka= (WebView) findViewById(R.id.wvDhaka);
                        wvDhaka.getSettings().setJavaScriptEnabled(true);
                        wvDhaka.loadUrl(urlDhaka);

                    }

                    else if (icon.equals("04d")){

                        String urlDhaka="http://openweathermap.org/img/w/04d.png";
                        WebView wvDhaka= (WebView) findViewById(R.id.wvDhaka);
                        wvDhaka.getSettings().setJavaScriptEnabled(true);
                        wvDhaka.loadUrl(urlDhaka);

                    }

                    else if (icon.equals("09d")){

                        String urlDhaka="http://openweathermap.org/img/w/09d.png";
                        WebView wvDhaka= (WebView) findViewById(R.id.wvDhaka);
                        wvDhaka.getSettings().setJavaScriptEnabled(true);
                        wvDhaka.loadUrl(urlDhaka);

                    }

                    else if (icon.equals("10d")){

                        String urlDhaka="http://openweathermap.org/img/w/10d.png";
                        WebView wvDhaka= (WebView) findViewById(R.id.wvDhaka);
                        wvDhaka.getSettings().setJavaScriptEnabled(true);
                        wvDhaka.loadUrl(urlDhaka);

                    }

                    else if (icon.equals("11d")){

                        String urlDhaka="http://openweathermap.org/img/w/11d.png";
                        WebView wvDhaka= (WebView) findViewById(R.id.wvDhaka);
                        wvDhaka.getSettings().setJavaScriptEnabled(true);
                        wvDhaka.loadUrl(urlDhaka);

                    }

                    else if (icon.equals("13d")){

                        String urlDhaka="http://openweathermap.org/img/w/13d.png";
                        WebView wvDhaka= (WebView) findViewById(R.id.wvDhaka);
                        wvDhaka.getSettings().setJavaScriptEnabled(true);
                        wvDhaka.loadUrl(urlDhaka);

                    }

                    else if (icon.equals("50d")){

                        String urlDhaka="http://openweathermap.org/img/w/50d.png";
                        WebView wvDhaka= (WebView) findViewById(R.id.wvDhaka);
                        wvDhaka.getSettings().setJavaScriptEnabled(true);
                        wvDhaka.loadUrl(urlDhaka);

                    }
                    else {
                        String urlDhaka="http://openweathermap.org/img/w/01n.png";
                        WebView wvDhaka= (WebView) findViewById(R.id.wvDhaka);
                        wvDhaka.getSettings().setJavaScriptEnabled(true);
                        wvDhaka.loadUrl(urlDhaka);
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
    public void dhaka(View view){
        startActivity(new Intent(this, Dhaka.class));
    }


    public void mymensinghMethod() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlMymensingh, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray weather = response.getJSONArray("weather");
                    JSONObject jsonObject = weather.getJSONObject(0);
                    JSONObject tempObject = response.getJSONObject("main");
                    JSONObject countryObject = response.getJSONObject("sys");


                    //String description = jsonObject.getString("description");
                    String icon = jsonObject.getString("icon");
                    String kalvintemperature = tempObject.getString("temp");
                    double dubTemp=Double.parseDouble(kalvintemperature)-273;
                    int intTemp=(int)dubTemp;
                    String temperature=String.valueOf(intTemp);
                    String division = response.getString("name");
                    String countryJson = countryObject.getString("country");

                    Date date = new Date();

                    String strHour = "hh";
                    SimpleDateFormat hour = new SimpleDateFormat(strHour);
                    String Hour = hour.format(date);
                    String strMin = "mm";
                    SimpleDateFormat min = new SimpleDateFormat(strMin);
                    String Minutes = min.format(date);
                    String time = Hour + " : " + Minutes;


                    if (countryJson.equals("BD")) {
                        String country = "Bangladesh";
                        tvMymensinghCountry.setText(country);
                    }else {

                    }
                    tvMymensinghTemperature.setText(temperature+"℃");
                    tvMymensinghDivision.setText(division);
                    tvMymensinghTime.setText(time);



                    if (icon.equals("01d")){

                        String urlMymensingh="http://openweathermap.org/img/w/01d.png";
                        WebView wvMymensingh= (WebView) findViewById(R.id.wvMymensingh);
                        wvMymensingh.getSettings().setJavaScriptEnabled(true);
                        wvMymensingh.loadUrl(urlMymensingh);

                    }

                    else if (icon.equals("02d")){

                        String urlMymensingh="http://openweathermap.org/img/w/02d.png";
                        WebView wvMymensingh= (WebView) findViewById(R.id.wvMymensingh);
                        wvMymensingh.getSettings().setJavaScriptEnabled(true);
                        wvMymensingh.loadUrl(urlMymensingh);

                    }

                    else if (icon.equals("03d")){

                        String urlMymensingh="http://openweathermap.org/img/w/03d.png";
                        WebView wvMymensingh= (WebView) findViewById(R.id.wvMymensingh);
                        wvMymensingh.getSettings().setJavaScriptEnabled(true);
                        wvMymensingh.loadUrl(urlMymensingh);

                    }

                    else if (icon.equals("04d")){

                        String urlMymensingh="http://openweathermap.org/img/w/04d.png";
                        WebView wvMymensingh= (WebView) findViewById(R.id.wvMymensingh);
                        wvMymensingh.getSettings().setJavaScriptEnabled(true);
                        wvMymensingh.loadUrl(urlMymensingh);

                    }

                    else if (icon.equals("09d")){

                        String urlMymensingh="http://openweathermap.org/img/w/09d.png";
                        WebView wvMymensingh= (WebView) findViewById(R.id.wvMymensingh);
                        wvMymensingh.getSettings().setJavaScriptEnabled(true);
                        wvMymensingh.loadUrl(urlMymensingh);

                    }

                    else if (icon.equals("10d")){

                        String urlMymensingh="http://openweathermap.org/img/w/10d.png";
                        WebView wvMymensingh= (WebView) findViewById(R.id.wvMymensingh);
                        wvMymensingh.getSettings().setJavaScriptEnabled(true);
                        wvMymensingh.loadUrl(urlMymensingh);

                    }

                    else if (icon.equals("11d")){

                        String urlMymensingh="http://openweathermap.org/img/w/11d.png";
                        WebView wvMymensingh= (WebView) findViewById(R.id.wvMymensingh);
                        wvMymensingh.getSettings().setJavaScriptEnabled(true);
                        wvMymensingh.loadUrl(urlMymensingh);

                    }

                    else if (icon.equals("13d")){

                        String urlMymensingh="http://openweathermap.org/img/w/13d.png";
                        WebView wvMymensingh= (WebView) findViewById(R.id.wvMymensingh);
                        wvMymensingh.getSettings().setJavaScriptEnabled(true);
                        wvMymensingh.loadUrl(urlMymensingh);

                    }

                    else if (icon.equals("50d")){

                        String urlMymensingh="http://openweathermap.org/img/w/50d.png";
                        WebView wvMymensingh= (WebView) findViewById(R.id.wvMymensingh);
                        wvMymensingh.getSettings().setJavaScriptEnabled(true);
                        wvMymensingh.loadUrl(urlMymensingh);

                    }
                    else {
                        String urlMymensingh="http://openweathermap.org/img/w/01n.png";
                        WebView wvMymensingh= (WebView) findViewById(R.id.wvMymensingh);
                        wvMymensingh.getSettings().setJavaScriptEnabled(true);
                        wvMymensingh.loadUrl(urlMymensingh);
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
    public void mymensingh(View view){
        startActivity(new Intent(this, Mymensingh.class));
    }


    public void chittagongMethod() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlChittagong, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray weather = response.getJSONArray("weather");
                    JSONObject jsonObject = weather.getJSONObject(0);
                    JSONObject tempObject = response.getJSONObject("main");
                    JSONObject countryObject = response.getJSONObject("sys");


                    //String description = jsonObject.getString("description");
                    String icon = jsonObject.getString("icon");
                    String kalvintemperature = tempObject.getString("temp");
                    double dubTemp=Double.parseDouble(kalvintemperature)-273;
                    int intTemp=(int)dubTemp;
                    String temperature=String.valueOf(intTemp);
                    String division = response.getString("name");
                    String countryJson = countryObject.getString("country");

                    Date date = new Date();

                    String strHour = "hh";
                    SimpleDateFormat hour = new SimpleDateFormat(strHour);
                    String Hour = hour.format(date);
                    String strMin = "mm";
                    SimpleDateFormat min = new SimpleDateFormat(strMin);
                    String Minutes = min.format(date);
                    String time = Hour + " : " + Minutes;


                    if (countryJson.equals("BD")) {
                        String country = "Bangladesh";
                        tvChittagongCountry.setText(country);
                    }else {

                    }
                    tvChittagongTemperature.setText(temperature+"℃");
                    tvChittagongDivision.setText(division);
                    tvChittagongTime.setText(time);



                    if (icon.equals("01d")){

                        String urlChittagong="http://openweathermap.org/img/w/01d.png";
                        WebView wvChittagong= (WebView) findViewById(R.id.wvChittagong);
                        wvChittagong.getSettings().setJavaScriptEnabled(true);
                        wvChittagong.loadUrl(urlChittagong);

                    }

                    else if (icon.equals("02d")){

                        String urlChittagong="http://openweathermap.org/img/w/02d.png";
                        WebView wvChittagong= (WebView) findViewById(R.id.wvChittagong);
                        wvChittagong.getSettings().setJavaScriptEnabled(true);
                        wvChittagong.loadUrl(urlChittagong);

                    }

                    else if (icon.equals("03d")){

                        String urlChittagong="http://openweathermap.org/img/w/03d.png";
                        WebView wvChittagong= (WebView) findViewById(R.id.wvChittagong);
                        wvChittagong.getSettings().setJavaScriptEnabled(true);
                        wvChittagong.loadUrl(urlChittagong);

                    }

                    else if (icon.equals("04d")){

                        String urlChittagong="http://openweathermap.org/img/w/04d.png";
                        WebView wvChittagong= (WebView) findViewById(R.id.wvChittagong);
                        wvChittagong.getSettings().setJavaScriptEnabled(true);
                        wvChittagong.loadUrl(urlChittagong);

                    }

                    else if (icon.equals("09d")){

                        String urlChittagong="http://openweathermap.org/img/w/09d.png";
                        WebView wvChittagong= (WebView) findViewById(R.id.wvChittagong);
                        wvChittagong.getSettings().setJavaScriptEnabled(true);
                        wvChittagong.loadUrl(urlChittagong);

                    }

                    else if (icon.equals("10d")){

                        String urlChittagong="http://openweathermap.org/img/w/10d.png";
                        WebView wvChittagong= (WebView) findViewById(R.id.wvChittagong);
                        wvChittagong.getSettings().setJavaScriptEnabled(true);
                        wvChittagong.loadUrl(urlChittagong);

                    }

                    else if (icon.equals("11d")){

                        String urlChittagong="http://openweathermap.org/img/w/11d.png";
                        WebView wvChittagong= (WebView) findViewById(R.id.wvChittagong);
                        wvChittagong.getSettings().setJavaScriptEnabled(true);
                        wvChittagong.loadUrl(urlChittagong);
                    }

                    else if (icon.equals("13d")){

                        String urlChittagong="http://openweathermap.org/img/w/13d.png";
                        WebView wvChittagong= (WebView) findViewById(R.id.wvChittagong);
                        wvChittagong.getSettings().setJavaScriptEnabled(true);
                        wvChittagong.loadUrl(urlChittagong);

                    }

                    else if (icon.equals("50d")){

                        String urlChittagong="http://openweathermap.org/img/w/50d.png";
                        WebView wvChittagong= (WebView) findViewById(R.id.wvChittagong);
                        wvChittagong.getSettings().setJavaScriptEnabled(true);
                        wvChittagong.loadUrl(urlChittagong);

                    }
                    else {
                        String urlChittagong="http://openweathermap.org/img/w/01n.png";
                        WebView wvChittagong= (WebView) findViewById(R.id.wvChittagong);
                        wvChittagong.getSettings().setJavaScriptEnabled(true);
                        wvChittagong.loadUrl(urlChittagong);
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
    public void chittagong(View view){
        startActivity(new Intent(this, Chittagong.class));
    }


    public void sylhetMethod() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlSylhet, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray weather = response.getJSONArray("weather");
                    JSONObject jsonObject = weather.getJSONObject(0);
                    JSONObject tempObject = response.getJSONObject("main");
                    JSONObject countryObject = response.getJSONObject("sys");


                    //String description = jsonObject.getString("description");
                    String icon = jsonObject.getString("icon");
                    String kalvintemperature = tempObject.getString("temp");
                    double dubTemp=Double.parseDouble(kalvintemperature)-273;
                    int intTemp=(int)dubTemp;
                    String temperature=String.valueOf(intTemp);
                    String division = response.getString("name");
                    String countryJson = countryObject.getString("country");

                    Date date = new Date();

                    String strHour = "hh";
                    SimpleDateFormat hour = new SimpleDateFormat(strHour);
                    String Hour = hour.format(date);
                    String strMin = "mm";
                    SimpleDateFormat min = new SimpleDateFormat(strMin);
                    String Minutes = min.format(date);
                    String time = Hour + " : " + Minutes;


                    if (countryJson.equals("BD")) {
                        String country = "Bangladesh";
                        tvSylhetCountry.setText(country);
                    }else {

                    }
                    tvSylhetTemperature.setText(temperature+"℃");
                    tvSylhetDivision.setText(division);
                    tvSylhetTime.setText(time);



                    if (icon.equals("01d")){

                        String urlSylhet="http://openweathermap.org/img/w/01d.png";
                        WebView wvSylhet= (WebView) findViewById(R.id.wvSylhet);
                        wvSylhet.getSettings().setJavaScriptEnabled(true);
                        wvSylhet.loadUrl(urlSylhet);

                    }

                    else if (icon.equals("02d")){

                        String urlSylhet="http://openweathermap.org/img/w/02d.png";
                        WebView wvSylhet= (WebView) findViewById(R.id.wvSylhet);
                        wvSylhet.getSettings().setJavaScriptEnabled(true);
                        wvSylhet.loadUrl(urlSylhet);

                    }

                    else if (icon.equals("03d")){

                        String urlSylhet="http://openweathermap.org/img/w/03d.png";
                        WebView wvSylhet= (WebView) findViewById(R.id.wvSylhet);
                        wvSylhet.getSettings().setJavaScriptEnabled(true);
                        wvSylhet.loadUrl(urlSylhet);

                    }

                    else if (icon.equals("04d")){

                        String urlSylhet="http://openweathermap.org/img/w/04d.png";
                        WebView wvSylhet= (WebView) findViewById(R.id.wvSylhet);
                        wvSylhet.getSettings().setJavaScriptEnabled(true);
                        wvSylhet.loadUrl(urlSylhet);

                    }

                    else if (icon.equals("09d")){

                        String urlSylhet="http://openweathermap.org/img/w/09d.png";
                        WebView wvSylhet= (WebView) findViewById(R.id.wvSylhet);
                        wvSylhet.getSettings().setJavaScriptEnabled(true);
                        wvSylhet.loadUrl(urlSylhet);

                    }

                    else if (icon.equals("10d")){

                        String urlSylhet="http://openweathermap.org/img/w/10d.png";
                        WebView wvSylhet= (WebView) findViewById(R.id.wvSylhet);
                        wvSylhet.getSettings().setJavaScriptEnabled(true);
                        wvSylhet.loadUrl(urlSylhet);

                    }

                    else if (icon.equals("11d")){

                        String urlSylhet="http://openweathermap.org/img/w/11d.png";
                        WebView wvSylhet= (WebView) findViewById(R.id.wvSylhet);
                        wvSylhet.getSettings().setJavaScriptEnabled(true);
                        wvSylhet.loadUrl(urlSylhet);
                    }

                    else if (icon.equals("13d")){

                        String urlSylhet="http://openweathermap.org/img/w/13d.png";
                        WebView wvSylhet= (WebView) findViewById(R.id.wvSylhet);
                        wvSylhet.getSettings().setJavaScriptEnabled(true);
                        wvSylhet.loadUrl(urlSylhet);

                    }

                    else if (icon.equals("50d")){

                        String urlSylhet="http://openweathermap.org/img/w/50d.png";
                        WebView wvSylhet= (WebView) findViewById(R.id.wvSylhet);
                        wvSylhet.getSettings().setJavaScriptEnabled(true);
                        wvSylhet.loadUrl(urlSylhet);

                    }
                    else {
                        String urlSylhet="http://openweathermap.org/img/w/01n.png";
                        WebView wvSylhet= (WebView) findViewById(R.id.wvSylhet);
                        wvSylhet.getSettings().setJavaScriptEnabled(true);
                        wvSylhet.loadUrl(urlSylhet);
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
    public void sylhet(View view){
        startActivity(new Intent(this, Sylhet.class));
    }


    public void rangpurMethod() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlRangpur, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray weather = response.getJSONArray("weather");
                    JSONObject jsonObject = weather.getJSONObject(0);
                    JSONObject tempObject = response.getJSONObject("main");
                    JSONObject countryObject = response.getJSONObject("sys");


                    //String description = jsonObject.getString("description");
                    String icon = jsonObject.getString("icon");
                    String kalvintemperature = tempObject.getString("temp");
                    double dubTemp=Double.parseDouble(kalvintemperature)-273;
                    int intTemp=(int)dubTemp;
                    String temperature=String.valueOf(intTemp);
                    String division = response.getString("name");
                    String countryJson = countryObject.getString("country");

                    Date date = new Date();

                    String strHour = "hh";
                    SimpleDateFormat hour = new SimpleDateFormat(strHour);
                    String Hour = hour.format(date);
                    String strMin = "mm";
                    SimpleDateFormat min = new SimpleDateFormat(strMin);
                    String Minutes = min.format(date);
                    String time = Hour + " : " + Minutes;


                    if (countryJson.equals("BD")) {
                        String country = "Bangladesh";
                        tvRangpurCountry.setText(country);
                    }else {

                    }
                    tvRangpurTemperature.setText(temperature+"℃");
                    tvRangpurDivision.setText(division);
                    tvRangpurTime.setText(time);



                    if (icon.equals("01d")){

                        String urlRangpur="http://openweathermap.org/img/w/01d.png";
                        WebView wvRangpur= (WebView) findViewById(R.id.wvRangpur);
                        wvRangpur.getSettings().setJavaScriptEnabled(true);
                        wvRangpur.loadUrl(urlRangpur);

                    }

                    else if (icon.equals("02d")){

                        String urlRangpur="http://openweathermap.org/img/w/02d.png";
                        WebView wvRangpur= (WebView) findViewById(R.id.wvRangpur);
                        wvRangpur.getSettings().setJavaScriptEnabled(true);
                        wvRangpur.loadUrl(urlRangpur);

                    }

                    else if (icon.equals("03d")){

                        String urlRangpur="http://openweathermap.org/img/w/03d.png";
                        WebView wvRangpur= (WebView) findViewById(R.id.wvRangpur);
                        wvRangpur.getSettings().setJavaScriptEnabled(true);
                        wvRangpur.loadUrl(urlRangpur);

                    }

                    else if (icon.equals("04d")){

                        String urlRangpur="http://openweathermap.org/img/w/04d.png";
                        WebView wvRangpur= (WebView) findViewById(R.id.wvRangpur);
                        wvRangpur.getSettings().setJavaScriptEnabled(true);
                        wvRangpur.loadUrl(urlRangpur);

                    }

                    else if (icon.equals("09d")){

                        String urlRangpur="http://openweathermap.org/img/w/09d.png";
                        WebView wvRangpur= (WebView) findViewById(R.id.wvRangpur);
                        wvRangpur.getSettings().setJavaScriptEnabled(true);
                        wvRangpur.loadUrl(urlRangpur);

                    }

                    else if (icon.equals("10d")){

                        String urlRangpur="http://openweathermap.org/img/w/10d.png";
                        WebView wvRangpur= (WebView) findViewById(R.id.wvRangpur);
                        wvRangpur.getSettings().setJavaScriptEnabled(true);
                        wvRangpur.loadUrl(urlRangpur);

                    }

                    else if (icon.equals("11d")){

                        String urlRangpur="http://openweathermap.org/img/w/11d.png";
                        WebView wvRangpur= (WebView) findViewById(R.id.wvRangpur);
                        wvRangpur.getSettings().setJavaScriptEnabled(true);
                        wvRangpur.loadUrl(urlRangpur);
                    }

                    else if (icon.equals("13d")){

                        String urlRangpur="http://openweathermap.org/img/w/13d.png";
                        WebView wvRangpur= (WebView) findViewById(R.id.wvRangpur);
                        wvRangpur.getSettings().setJavaScriptEnabled(true);
                        wvRangpur.loadUrl(urlRangpur);

                    }

                    else if (icon.equals("50d")){

                        String urlRangpur="http://openweathermap.org/img/w/50d.png";
                        WebView wvRangpur= (WebView) findViewById(R.id.wvRangpur);
                        wvRangpur.getSettings().setJavaScriptEnabled(true);
                        wvRangpur.loadUrl(urlRangpur);

                    }
                    else {
                        String urlRangpur="http://openweathermap.org/img/w/01n.png";
                        WebView wvRangpur= (WebView) findViewById(R.id.wvRangpur);
                        wvRangpur.getSettings().setJavaScriptEnabled(true);
                        wvRangpur.loadUrl(urlRangpur);
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
    public void rangpur(View view){
        startActivity(new Intent(this, Rangpur.class));
    }


    public void rajshahiMethod() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlRajshahi, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray weather = response.getJSONArray("weather");
                    JSONObject jsonObject = weather.getJSONObject(0);
                    JSONObject tempObject = response.getJSONObject("main");
                    JSONObject countryObject = response.getJSONObject("sys");


                    //String description = jsonObject.getString("description");
                    String icon = jsonObject.getString("icon");
                    String kalvintemperature = tempObject.getString("temp");
                    double dubTemp=Double.parseDouble(kalvintemperature)-273;
                    int intTemp=(int)dubTemp;
                    String temperature=String.valueOf(intTemp);
                    String division = response.getString("name");
                    String countryJson = countryObject.getString("country");

                    Date date = new Date();

                    String strHour = "hh";
                    SimpleDateFormat hour = new SimpleDateFormat(strHour);
                    String Hour = hour.format(date);
                    String strMin = "mm";
                    SimpleDateFormat min = new SimpleDateFormat(strMin);
                    String Minutes = min.format(date);
                    String time = Hour + " : " + Minutes;


                    if (countryJson.equals("BD")) {
                        String country = "Bangladesh";
                        tvRajshahiCountry.setText(country);
                    }else {

                    }
                    tvRajshahiTemperature.setText(temperature+"℃");
                    tvRajshahiDivision.setText(division);
                    tvRajshahiTime.setText(time);



                    if (icon.equals("01d")){

                        String urlRajshahi="http://openweathermap.org/img/w/01d.png";
                        WebView wvRajshahi= (WebView) findViewById(R.id.wvRajshahi);
                        wvRajshahi.getSettings().setJavaScriptEnabled(true);
                        wvRajshahi.loadUrl(urlRajshahi);

                    }

                    else if (icon.equals("02d")){

                        String urlRajshahi="http://openweathermap.org/img/w/02d.png";
                        WebView wvRajshahi= (WebView) findViewById(R.id.wvRajshahi);
                        wvRajshahi.getSettings().setJavaScriptEnabled(true);
                        wvRajshahi.loadUrl(urlRajshahi);

                    }

                    else if (icon.equals("03d")){

                        String urlRajshahi="http://openweathermap.org/img/w/03d.png";
                        WebView wvRajshahi= (WebView) findViewById(R.id.wvRajshahi);
                        wvRajshahi.getSettings().setJavaScriptEnabled(true);
                        wvRajshahi.loadUrl(urlRajshahi);

                    }

                    else if (icon.equals("04d")){

                        String urlRajshahi="http://openweathermap.org/img/w/04d.png";
                        WebView wvRajshahi= (WebView) findViewById(R.id.wvRajshahi);
                        wvRajshahi.getSettings().setJavaScriptEnabled(true);
                        wvRajshahi.loadUrl(urlRajshahi);

                    }

                    else if (icon.equals("09d")){

                        String urlRajshahi="http://openweathermap.org/img/w/09d.png";
                        WebView wvRajshahi= (WebView) findViewById(R.id.wvRajshahi);
                        wvRajshahi.getSettings().setJavaScriptEnabled(true);
                        wvRajshahi.loadUrl(urlRajshahi);

                    }

                    else if (icon.equals("10d")){

                        String urlRajshahi="http://openweathermap.org/img/w/10d.png";
                        WebView wvRajshahi= (WebView) findViewById(R.id.wvRajshahi);
                        wvRajshahi.getSettings().setJavaScriptEnabled(true);
                        wvRajshahi.loadUrl(urlRajshahi);

                    }

                    else if (icon.equals("11d")){

                        String urlRajshahi="http://openweathermap.org/img/w/11d.png";
                        WebView wvRajshahi= (WebView) findViewById(R.id.wvRajshahi);
                        wvRajshahi.getSettings().setJavaScriptEnabled(true);
                        wvRajshahi.loadUrl(urlRajshahi);
                    }

                    else if (icon.equals("13d")){

                        String urlRajshahi="http://openweathermap.org/img/w/13d.png";
                        WebView wvRajshahi= (WebView) findViewById(R.id.wvRajshahi);
                        wvRajshahi.getSettings().setJavaScriptEnabled(true);
                        wvRajshahi.loadUrl(urlRajshahi);

                    }

                    else if (icon.equals("50d")){

                        String urlRajshahi="http://openweathermap.org/img/w/50d.png";
                        WebView wvRajshahi= (WebView) findViewById(R.id.wvRajshahi);
                        wvRajshahi.getSettings().setJavaScriptEnabled(true);
                        wvRajshahi.loadUrl(urlRajshahi);

                    }
                    else {
                        String urlRajshahi="http://openweathermap.org/img/w/01n.png";
                        WebView wvRajshahi= (WebView) findViewById(R.id.wvRajshahi);
                        wvRajshahi.getSettings().setJavaScriptEnabled(true);
                        wvRajshahi.loadUrl(urlRajshahi);
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
    public void rajshahi(View view){
        startActivity(new Intent(this, Rajshahi.class));
    }


    public void khulnaMethod() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlKhulna, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray weather = response.getJSONArray("weather");
                    JSONObject jsonObject = weather.getJSONObject(0);
                    JSONObject tempObject = response.getJSONObject("main");
                    JSONObject countryObject = response.getJSONObject("sys");


                    //String description = jsonObject.getString("description");
                    String icon = jsonObject.getString("icon");
                    String kalvintemperature = tempObject.getString("temp");
                    double dubTemp=Double.parseDouble(kalvintemperature)-273;
                    int intTemp=(int)dubTemp;
                    String temperature=String.valueOf(intTemp);
                    String division = response.getString("name");
                    String countryJson = countryObject.getString("country");

                    Date date = new Date();

                    String strHour = "hh";
                    SimpleDateFormat hour = new SimpleDateFormat(strHour);
                    String Hour = hour.format(date);
                    String strMin = "mm";
                    SimpleDateFormat min = new SimpleDateFormat(strMin);
                    String Minutes = min.format(date);
                    String time = Hour + " : " + Minutes;


                    if (countryJson.equals("BD")) {
                        String country = "Bangladesh";
                        tvKhulnaCountry.setText(country);
                    }else {

                    }
                    tvKhulnaTemperature.setText(temperature+"℃");
                    tvKhulnaDivision.setText(division);
                    tvKhulnaTime.setText(time);



                    if (icon.equals("01d")){

                        String urlKhulna="http://openweathermap.org/img/w/01d.png";
                        WebView wvKhulna= (WebView) findViewById(R.id.wvKhulna);
                        wvKhulna.getSettings().setJavaScriptEnabled(true);
                        wvKhulna.loadUrl(urlKhulna);

                    }

                    else if (icon.equals("02d")){

                        String urlKhulna="http://openweathermap.org/img/w/02d.png";
                        WebView wvKhulna= (WebView) findViewById(R.id.wvKhulna);
                        wvKhulna.getSettings().setJavaScriptEnabled(true);
                        wvKhulna.loadUrl(urlKhulna);

                    }

                    else if (icon.equals("03d")){

                        String urlKhulna="http://openweathermap.org/img/w/03d.png";
                        WebView wvKhulna= (WebView) findViewById(R.id.wvKhulna);
                        wvKhulna.getSettings().setJavaScriptEnabled(true);
                        wvKhulna.loadUrl(urlKhulna);

                    }

                    else if (icon.equals("04d")){

                        String urlKhulna="http://openweathermap.org/img/w/04d.png";
                        WebView wvKhulna= (WebView) findViewById(R.id.wvKhulna);
                        wvKhulna.getSettings().setJavaScriptEnabled(true);
                        wvKhulna.loadUrl(urlKhulna);

                    }

                    else if (icon.equals("09d")){

                        String urlKhulna="http://openweathermap.org/img/w/09d.png";
                        WebView wvKhulna= (WebView) findViewById(R.id.wvKhulna);
                        wvKhulna.getSettings().setJavaScriptEnabled(true);
                        wvKhulna.loadUrl(urlKhulna);

                    }

                    else if (icon.equals("10d")){

                        String urlKhulna="http://openweathermap.org/img/w/10d.png";
                        WebView wvKhulna= (WebView) findViewById(R.id.wvKhulna);
                        wvKhulna.getSettings().setJavaScriptEnabled(true);
                        wvKhulna.loadUrl(urlKhulna);

                    }

                    else if (icon.equals("11d")){

                        String urlKhulna="http://openweathermap.org/img/w/11d.png";
                        WebView wvKhulna= (WebView) findViewById(R.id.wvKhulna);
                        wvKhulna.getSettings().setJavaScriptEnabled(true);
                        wvKhulna.loadUrl(urlKhulna);
                    }

                    else if (icon.equals("13d")){

                        String urlKhulna="http://openweathermap.org/img/w/13d.png";
                        WebView wvKhulna= (WebView) findViewById(R.id.wvKhulna);
                        wvKhulna.getSettings().setJavaScriptEnabled(true);
                        wvKhulna.loadUrl(urlKhulna);

                    }

                    else if (icon.equals("50d")){

                        String urlKhulna="http://openweathermap.org/img/w/50d.png";
                        WebView wvKhulna= (WebView) findViewById(R.id.wvKhulna);
                        wvKhulna.getSettings().setJavaScriptEnabled(true);
                        wvKhulna.loadUrl(urlKhulna);

                    }
                    else {
                        String urlKhulna="http://openweathermap.org/img/w/01n.png";
                        WebView wvKhulna= (WebView) findViewById(R.id.wvKhulna);
                        wvKhulna.getSettings().setJavaScriptEnabled(true);
                        wvKhulna.loadUrl(urlKhulna);
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
    public void khulna(View view){
        startActivity(new Intent(this, Khulna.class));
    }


    public void barisalMethod() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlBarisal, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray weather = response.getJSONArray("weather");
                    JSONObject jsonObject = weather.getJSONObject(0);
                    JSONObject tempObject = response.getJSONObject("main");
                    JSONObject countryObject = response.getJSONObject("sys");


                    //String description = jsonObject.getString("description");
                    String icon = jsonObject.getString("icon");
                    String kalvintemperature = tempObject.getString("temp");
                    double dubTemp=Double.parseDouble(kalvintemperature)-273;
                    int intTemp=(int)dubTemp;
                    String temperature=String.valueOf(intTemp);
                    String division = response.getString("name");
                    String countryJson = countryObject.getString("country");

                    Date date = new Date();

                    String strHour = "hh";
                    SimpleDateFormat hour = new SimpleDateFormat(strHour);
                    String Hour = hour.format(date);
                    String strMin = "mm";
                    SimpleDateFormat min = new SimpleDateFormat(strMin);
                    String Minutes = min.format(date);
                    String time = Hour + " : " + Minutes;


                    if (countryJson.equals("BD")) {
                        String country = "Bangladesh";
                        tvBarisalCountry.setText(country);
                    }else {

                    }
                    tvBarisalTemperature.setText(temperature+"℃");
                    tvBarisalDivision.setText(division);
                    tvBarisalTime.setText(time);



                    if (icon.equals("01d")){

                        String urlBarisal="http://openweathermap.org/img/w/01d.png";
                        WebView wvBarisal= (WebView) findViewById(R.id.wvBarisal);
                        wvBarisal.getSettings().setJavaScriptEnabled(true);
                        wvBarisal.loadUrl(urlBarisal);

                    }

                    else if (icon.equals("02d")){

                        String urlBarisal="http://openweathermap.org/img/w/03d.png";
                        WebView wvBarisal= (WebView) findViewById(R.id.wvBarisal);
                        wvBarisal.getSettings().setJavaScriptEnabled(true);
                        wvBarisal.loadUrl(urlBarisal);

                    }

                    else if (icon.equals("03d")){

                        String urlBarisal="http://openweathermap.org/img/w/01d.png";
                        WebView wvBarisal= (WebView) findViewById(R.id.wvBarisal);
                        wvBarisal.getSettings().setJavaScriptEnabled(true);
                        wvBarisal.loadUrl(urlBarisal);

                    }

                    else if (icon.equals("04d")){

                        String urlBarisal="http://openweathermap.org/img/w/04d.png";
                        WebView wvBarisal= (WebView) findViewById(R.id.wvBarisal);
                        wvBarisal.getSettings().setJavaScriptEnabled(true);
                        wvBarisal.loadUrl(urlBarisal);

                    }

                    else if (icon.equals("09d")){

                        String urlBarisal="http://openweathermap.org/img/w/09d.png";
                        WebView wvBarisal= (WebView) findViewById(R.id.wvBarisal);
                        wvBarisal.getSettings().setJavaScriptEnabled(true);
                        wvBarisal.loadUrl(urlBarisal);

                    }

                    else if (icon.equals("10d")){

                        String urlBarisal="http://openweathermap.org/img/w/10d.png";
                        WebView wvBarisal= (WebView) findViewById(R.id.wvBarisal);
                        wvBarisal.getSettings().setJavaScriptEnabled(true);
                        wvBarisal.loadUrl(urlBarisal);

                    }

                    else if (icon.equals("11d")){

                        String urlBarisal="http://openweathermap.org/img/w/11d.png";
                        WebView wvBarisal= (WebView) findViewById(R.id.wvBarisal);
                        wvBarisal.getSettings().setJavaScriptEnabled(true);
                        wvBarisal.loadUrl(urlBarisal);
                    }

                    else if (icon.equals("13d")){

                        String urlBarisal="http://openweathermap.org/img/w/13d.png";
                        WebView wvBarisal= (WebView) findViewById(R.id.wvBarisal);
                        wvBarisal.getSettings().setJavaScriptEnabled(true);
                        wvBarisal.loadUrl(urlBarisal);

                    }

                    else if (icon.equals("50d")){

                        String urlBarisal="http://openweathermap.org/img/w/50d.png";
                        WebView wvBarisal= (WebView) findViewById(R.id.wvBarisal);
                        wvBarisal.getSettings().setJavaScriptEnabled(true);
                        wvBarisal.loadUrl(urlBarisal);

                    }
                    else {
                        String urlBarisal="http://openweathermap.org/img/w/01n.png";
                        WebView wvBarisal= (WebView) findViewById(R.id.wvBarisal);
                        wvBarisal.getSettings().setJavaScriptEnabled(true);
                        wvBarisal.loadUrl(urlBarisal);
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
    public void barisal(View view){
        startActivity(new Intent(this, Barisal.class));
    }
}

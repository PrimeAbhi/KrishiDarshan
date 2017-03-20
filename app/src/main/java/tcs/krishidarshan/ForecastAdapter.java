/*
 *     Copyright 2016, 2017 IBM Corp.
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */
package tcs.krishidarshan;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import tcs.krishidarshan.model.Daily;
import tcs.krishidarshan.model.DailyForecast;
import tcs.krishidarshan.model.ForecastDaily;

/**
 * List adapter used to display detailed ten day forecast.
 */
public class ForecastAdapter extends BaseAdapter {

    private Gson gson;

    private Context mContext;
    private LayoutInflater mInflater;
    private DailyForecast mDailyForecast;

    public ForecastAdapter(Context context, DailyForecast dailyForecast) {
        mContext = context;
        mDailyForecast = dailyForecast;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {

        return mDailyForecast.getForecasts().size();
    }

    @Override
    public Object getItem(int position) {
        return mDailyForecast.getForecasts().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.forecast_entry, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.imageView);
            viewHolder.day = (TextView) convertView.findViewById(R.id.day);
            viewHolder.temp = (TextView) convertView.findViewById(R.id.daily_temp);
            viewHolder.narrative = (TextView) convertView.findViewById(R.id.daily_narrative);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (mDailyForecast == null) {
            return convertView;
        }
        ImageView icon = viewHolder.icon;
        TextView temp = viewHolder.temp;
        TextView narrative = viewHolder.narrative;
        TextView day = viewHolder.day;

        ForecastDaily forecast = mDailyForecast.getForecasts().get(position);
        Daily daily = (forecast.getDay() == null) ? forecast.getNight() : forecast.getDay();
        String temperature = daily.getTemp().toString() + "\u00B0";
        temp.setText(temperature);
        day.setText(daily.getDaypartName());
        narrative.setText(daily.getNarrative());

        Drawable drawable = null;
        int id = mContext.getResources().getIdentifier("ic_" + daily.getIconCode(), "drawable", mContext.getPackageName());

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            drawable = mContext.getDrawable(id);
        } else {
            drawable = mContext.getResources().getDrawable(id);
        }
        icon.setImageDrawable(drawable);

        return convertView;
    }

    private static class ViewHolder {
        public ImageView icon;
        TextView temp;
        TextView narrative;
        TextView day;
    }
}

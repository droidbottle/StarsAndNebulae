package droidbottle.com.starsandnebulae.utilities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import droidbottle.com.starsandnebulae.MainGridActivity;
import droidbottle.com.starsandnebulae.R;

/**
 * Created by delma.p on 06-02-2017.
 */
public class ImageAdapter extends BaseAdapter{
    private Context mContext;
    private final String[] web;
    private final int[] Imageid;

    public ImageAdapter(Context c,String[] web,int[] Imageid ) {
        mContext = c;
        this.Imageid = Imageid;
        this.web = web;
    }

    public int getCount() {
        return web.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridView;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            gridView = new View(mContext);
            gridView = inflater.inflate(R.layout.grid_single, null);
           // gridView.setMinimumHeight(MainGridActivity.height/4);
            TextView textView = (TextView) gridView.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView)gridView.findViewById(R.id.grid_image);
            gridView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            textView.setText(web[position]);
            imageView.setImageResource(Imageid[position]);
        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }
}

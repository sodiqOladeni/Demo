package ng.com.sodiqoladeni.demo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ng.com.sodiqoladeni.demo.R;
import ng.com.sodiqoladeni.demo.db.ContactEntity;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private Context mContext;
    private List<ContactEntity> dataModel;

    public ContactAdapter(Context mContext, List<ContactEntity> dataModel) {
        this.mContext = mContext;
        this.dataModel = dataModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int p) {
        h.name.setText(dataModel.get(p).getName());
        h.number.setText(dataModel.get(p).getNumber());
    }

    @Override
    public int getItemCount() {
        return dataModel.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView initial, name, number;

        public ViewHolder(@NonNull View i) {
            super(i);

            initial = i.findViewById(R.id.initial);
            name = i.findViewById(R.id.name);
            number = i.findViewById(R.id.number);
        }
    }
}

package com.example.reciclerviewtest1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class BuildingAdapter extends RecyclerView.Adapter<BuildingAdapter.BuildingViewHolder> {

    private List<Building> buildingList;
    private List<Building> buildingListFiltered;

    public BuildingAdapter(List<Building> buildingList) {
        this.buildingList = buildingList;
        this.buildingListFiltered = new ArrayList<>(buildingList);
    }
    @Override
    public BuildingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.building_item, parent, false);
        return new BuildingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BuildingViewHolder holder, int position) {
        Building building = buildingListFiltered.get(position);
        holder.titleTextView.setText(building.getTitle());
        holder.descriptionTextView.setText(building.getDescription());
        holder.imageView.setImageResource(building.getImageResource());
    }

    @Override
    public int getItemCount() {
        return buildingListFiltered.size();
    }

    public void filter(String query) {
        if (query.isEmpty()) {
            buildingListFiltered = new ArrayList<>(buildingList);
        } else {
            List<Building> filteredList = new ArrayList<>();
            for (Building building : buildingList) {
                if (building.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                        building.getDescription().toLowerCase().contains(query.toLowerCase())) {
                    filteredList.add(building);
                }
            }
            buildingListFiltered = filteredList;
        }
        notifyDataSetChanged();
    }

    public static class BuildingViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView;
        TextView descriptionTextView;

        public BuildingViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.building_image);
            titleTextView = itemView.findViewById(R.id.building_title);
            descriptionTextView = itemView.findViewById(R.id.building_description);
        }
    }
}

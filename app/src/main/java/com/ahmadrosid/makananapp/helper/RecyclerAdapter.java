package com.ahmadrosid.makananapp.helper;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by ocittwo on 1/8/17.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */

public abstract class RecyclerAdapter<T, H extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<H> {
    private List<T> listData;
    private Class<T> data;
    private Class<H> holder;
    private int layoutRes;

    public RecyclerAdapter(List<T> listData, Class<T> data, Class<H> holder, int layoutRes) {
        this.listData = listData;
        this.data = data;
        this.holder = holder;
        this.layoutRes = layoutRes;
    }

    @Override public int getItemCount() {
        return listData.size();
    }

    @Override public H onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutRes, parent, false);
        try {
            Constructor<H> constructor = holder.getConstructor(View.class);
            return constructor.newInstance(view);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override public void onBindViewHolder(H holder, int position) {
        bindHolder(holder, listData.get(position), position);
    }

    protected abstract void bindHolder(H holder, T data, int position);
}

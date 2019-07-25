package com.asu.asucourses.models;

import java.util.List;

public interface IService<T> {
    void onTaskCompleted(List<T> objects);
}

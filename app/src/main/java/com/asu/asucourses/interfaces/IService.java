package com.asu.asucourses.interfaces;

import java.util.List;

public interface IService<T> {
    void onTaskCompleted(List<T> objects);
}

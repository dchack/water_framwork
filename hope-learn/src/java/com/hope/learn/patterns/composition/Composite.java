package com.hope.learn.patterns.composition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hope on 2018/3/9.
 */
public class Composite extends Component{

    private List<Component> componentList = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void display() {
        for (Component component: componentList) {
            component.display();
        }
    }

    @Override
    public void add(Component component) {
        componentList.add(component);
    }

    @Override
    public void remove(Component component) {
        componentList.remove(component);
    }
}

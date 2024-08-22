package org.example;

import java.util.ArrayList;
import java.util.Collection;

public class Model3D implements Entity{
    private static int counter = 10000;
    private int id;
    private Collection<Texture> textures = new ArrayList<>();

    @Override
    public int getID() {
        return id;
    }

    public Model3D() {
    }

    {
        id = ++counter;
    }

    public Model3D(Collection<Texture> textures) {
        this.textures = textures;
    }

    public Collection<Texture> getTextures() {
        return textures;
    }

    @Override
    public String toString() {
        return String.format("3DModel №%s", id);
    }
}

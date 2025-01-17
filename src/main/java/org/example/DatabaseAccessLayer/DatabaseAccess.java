package org.example.DatabaseAccessLayer;

import org.example.Entity;
import org.example.Model3D;
import org.example.Texture;

import java.util.Collection;

public interface DatabaseAccess {

    void addEntity(Entity entity);
    void removeEntity(Entity entity);

    Collection<Texture> getAllTextures();
    Collection<Model3D> getAllModels();
}

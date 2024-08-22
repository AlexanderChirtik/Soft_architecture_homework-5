package org.example.BusinessLogicalLayer;

import org.example.Model3D;
import org.example.Texture;

import java.util.Collection;

public interface BusinessLogical {

    Collection<Model3D> getAllModels();
    Collection<Texture> getAllTextures();
    void renderModel(Model3D model3D);
    void renderAllModels();

}

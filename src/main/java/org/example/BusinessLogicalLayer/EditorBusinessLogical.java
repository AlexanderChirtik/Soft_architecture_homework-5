package org.example.BusinessLogicalLayer;

import org.example.DatabaseAccessLayer.DatabaseAccess;
import org.example.Model3D;
import org.example.Texture;

import java.util.Collection;
import java.util.Random;

public class EditorBusinessLogical implements BusinessLogical{

    private Random random = new Random();

    private final DatabaseAccess databaseAccess;

    public EditorBusinessLogical(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    @Override
    public Collection<Model3D> getAllModels() {
        return databaseAccess.getAllModels();
    }

    @Override
    public Collection<Texture> getAllTextures() {
        return databaseAccess.getAllTextures();
    }

    @Override
    public void renderModel(Model3D model3D) {
        processRender(model3D);
    }

    @Override
    public void renderAllModels() {
        for (Model3D model : getAllModels()){
            processRender(model);
        }
    }

    private void processRender(Model3D model) {
        try {
            Thread.sleep(2500 - random.nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

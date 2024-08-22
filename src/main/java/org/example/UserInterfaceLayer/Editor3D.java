package org.example.UserInterfaceLayer;

import com.sun.source.doctree.TextTree;
import org.example.BusinessLogicalLayer.BusinessLogical;
import org.example.BusinessLogicalLayer.EditorBusinessLogical;
import org.example.Database.Database;
import org.example.Database.EditorDatabase;
import org.example.DatabaseAccessLayer.DatabaseAccess;
import org.example.DatabaseAccessLayer.EditorDatabaseAccess;
import org.example.Model3D;
import org.example.ProjectFile;
import org.example.Texture;

import java.util.ArrayList;

public class Editor3D implements UILayer{

    private ProjectFile projectFile;
    private BusinessLogical businessLogical;
    private DatabaseAccess databaseAccess;
    private Database database;

    private void initialize() {
        database = new EditorDatabase(projectFile);
        databaseAccess = new EditorDatabaseAccess(database);
        businessLogical = new EditorBusinessLogical(databaseAccess);
    }

    private void checkProjectFile() {
        if (projectFile == null){
            throw new RuntimeException("Файл проекта не определен.");
        }
    }

    @Override
    public void openProject(String fileName) {
        projectFile = new ProjectFile(fileName);
        initialize();
    }

    @Override
    public void showProjectSettings() {
        //Предусловие
        checkProjectFile();

        System.out.println("***  Project v1  ***");
        System.out.println("**********************");
        System.out.printf("filename: %s\n", projectFile.getFileName());
        System.out.printf("setting1: %d\n", projectFile.getSetting1());
        System.out.printf("setting2: %s\n", projectFile.getSetting2());
        System.out.printf("setting3: %s\n", projectFile.getSetting3());
        System.out.println("***********************");
    }

    @Override
    public void saveProject() {
        //Предусловие
        checkProjectFile();

        database.save();
        System.out.println("Изменения успешно сохранены.");
    }

    @Override
    public void printAllModels() {
        //Предусловие
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>) businessLogical.getAllModels();
        for (int i = 0; i < models.size(); i++) {
            System.out.printf("===%d+++\n", i);
            System.out.println(models.get(i));
            for (Texture texture: models.get(i).getTextures()){
                System.out.printf("\t%s\n", texture);
            }
        }
    }

    @Override
    public void printAllTextures() {
        //Предусловие
        checkProjectFile();

        ArrayList<Texture> textures = (ArrayList<Texture>) businessLogical.getAllTextures();
        for (int i = 0; i < textures.size(); i++) {
            System.out.printf("===%d+++\n", i);
            System.out.println(textures.get(i));
        }
    }

    @Override
    public void renderAll() {
        //Предусловие
        checkProjectFile();

        System.out.println("Подождите......");
        long startTime = System.currentTimeMillis();
        businessLogical.renderAllModels();
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Операция выполнена за %d мс. \n", endTime);
    }

    @Override
    public void renderModel(int id) {
        //Предусловие
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>) businessLogical.getAllModels();
        if (id < 0 || id > models.size() - 1)
            throw new RuntimeException("Номер модели указан некорректно.");
        System.out.println("Подождите.........");
        long startTime = System.currentTimeMillis();
        businessLogical.renderModel(models.get(id));
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Операция выполнена за %d мс. \n", endTime);
    }
}

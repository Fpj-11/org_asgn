package layeredarchitecture.dao;

public class StorageFactory {
	public static StorageIntf getStorage() {
        return new StorageImpl(3); 
    }
	
	public static StorageIntf getFileStorage(String filename) {
        return new StorageFileImpl(filename);
    }
}

package layeredarchitecture.dao;

public class StorageFactory {
	public static StorageIntf getStorage() {
        return new StorageImpl(3); 
    }
}

import java.text.DecimalFormat;
import java.util.*;

abstract class Asset {
    private String name;
    private double value;
    private Date acquisitionDate;
    
    public Asset(String name, Double value, Date acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
        this.value = value;
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public double getValue() {
        return value;
    }
    
    public Date getAcquisitionDate() {
        return acquisitionDate;
    }
    
    public abstract double getDepreciation();
}

class FixedAsset extends Asset {
    
    private int usefulLife;
    
    public FixedAsset(String name, double value, Date acquisitionDate, int usefulLife) {
        super(name, value, acquisitionDate);
        this.usefulLife = usefulLife;
    }
    
    @Override
    public double getDepreciation() {
        return this.getValue() / usefulLife;
    }
}

class CurrentAsset extends Asset {
    public double liquidationValue;
    
    public CurrentAsset(String name, Double value, Date acquisitionDate,double liquidationValue) {
        super(name, value, acquisitionDate);
        this.liquidationValue = liquidationValue;
    }
    
    @Override
    public double getDepreciation() {
        return this.getValue() * 0.1;
    }
}

class IntangibleAsset extends Asset {
    private int liquidationValue;
    public IntangibleAsset(String name, Double value, Date acquisitionDate, int liquidationValue) {
        super(name, value, acquisitionDate);
        this.liquidationValue = liquidationValue;
    }
    
    @Override
    public double getDepreciation() {
        return this.getValue() / liquidationValue;
    }
}

class AssetManager {
    
    private List<Asset> assets;
    public AssetManager() {
        assets = new ArrayList<>();
    }
    
    public void addAsset(Asset asset) {
        assets.add(asset);
    }
    
    public double getTotalValue() {
        double total = 0;
        for (Asset asset : assets) {
            total += asset.getValue();
        }
        return total;
    }
    
    public double getTotalDepreciation() {
        double total = 0;
        for (Asset asset : assets) {
            total += asset.getDepreciation();
        }
        return total;
    }
    
    public List<Asset> getAssets() {
        return assets;
    }
    
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AssetManager manager = new AssetManager();
        
        int n = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            
            String type = parts[0];
            String name = parts[1];
            double value = Double.parseDouble(parts[2]);
            Date acquisitionDate = new Date();
            
            if (type.equals("FixedAsset")) {
                int usefulLife = Integer.parseInt(parts[3]);
                manager.addAsset(new FixedAsset(name, value, acquisitionDate, usefulLife));
            } else if (type.equals("CurrentAsset")) {
                double liquidationValue = Double.parseDouble(parts[3]);
                manager.addAsset(new CurrentAsset(name, value, acquisitionDate, liquidationValue));
            } else if (type.equals("IntangibleAsset")) {
                int amortizationPeriod = Integer.parseInt(parts[3]);
                manager.addAsset(new IntangibleAsset(name, value, acquisitionDate, amortizationPeriod));
            }
        }
        
        DecimalFormat df = new DecimalFormat("0.0");
        
        for (Asset asset : manager.getAssets()) {
            System.out.println("Asset Name: " + asset.getName());
            System.out.println("Asset Value: " + df.format(asset.getValue()));
            System.out.println("Depreciation: " + df.format(asset.getDepreciation()));
            System.out.println("------------------------------");
        }
        
        System.out.println("Total Value of Assets: " + df.format(manager.getTotalValue()));
        System.out.println("Total Depreciation of Assets: " + df.format(manager.getTotalDepreciation()));
    }
}

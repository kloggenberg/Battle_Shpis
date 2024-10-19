package battleships.game.ships;

public abstract class AbstractShip {
    private int shipHealth;
    private int hits;
    private String shipName;

    public AbstractShip(int shipHealth, String shipName) {
        this.shipName = shipName;
        this.shipHealth = shipHealth;
        this.hits = 0;
        System.out.println("Creating " + shipName + " of " + shipHealth);
    }
    public void takeHit (){
        this.hits++;
    }

    private void setHealth() {
        this.shipHealth = this.shipHealth - this.hits;
    }

    public int getShipHealth() {
        return shipHealth;
    }

    public String getShipName() {
        return shipName;
    }

    public boolean isSunk() {
        return this.shipHealth == 0;
    }

    @Override
    public String toString() {
        return "Ship Stats {" +
                "Ship type : " + this.getShipName() + " " +
                "ShipHealth : " + this.getShipHealth() +
                "}";
    }
}

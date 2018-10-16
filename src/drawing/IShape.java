package drawing;

public interface IShape {
    public void addShapeToPane(DrawingPane p);
    public void removeShapeFromPane(DrawingPane p);
    public void offset(double x,double y);
    public boolean isOn(double x,double y);
    void setSelected(boolean isSelected);
    boolean isSelected();

}

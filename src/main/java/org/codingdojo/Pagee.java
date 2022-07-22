package org.codingdojo;

public class Pagee {

  private final int current;
  private final int last;

  private Pagee(int current, int last) {
    this.current = current;
    this.last = last;
  }

  public static PaginationRenderBuilder builder() {
    return new PaginationRenderBuilder();
  }

  public String render() {
    // TODO: implement
    return null;
  }

  public static class PaginationRenderBuilder {
    private int current = 1;
    private int last;

    public PaginationRenderBuilder page(int current) {
      this.current = current;

      return this;
    }

    public PaginationRenderBuilder of(int last) {
      this.last = last;

      return this;
    }

    public Pagee build() {
      return new Pagee(current, last);
    }
  }
}

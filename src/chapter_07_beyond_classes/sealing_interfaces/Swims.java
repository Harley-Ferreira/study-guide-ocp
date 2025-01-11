package chapter_07_beyond_classes.sealing_interfaces;

// The idea is analogous to classes.
public sealed interface Swims permits Duck, Swan {
}

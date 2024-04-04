let pkgs = import (builtins.fetchTarball "channel:nixpkgs-unstable") {};
in
pkgs.mkShell {
  buildInputs = with pkgs; [
    jdk21
  ];

  packages = with pkgs; [
    jetbrains.idea-community
  ];

  shellHook = ''
    export LD_LIBRARY_PATH="$LD_LIBRARY_PATH:${pkgs.lib.makeLibraryPath (with pkgs; [
                 libGL
               ])}";
    export _JAVA_AWT_WM_NONREPARENTING=1
  '';
}

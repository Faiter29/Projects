# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.21

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:

#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:

# Disable VCS-based implicit rules.
% : %,v

# Disable VCS-based implicit rules.
% : RCS/%

# Disable VCS-based implicit rules.
% : RCS/%,v

# Disable VCS-based implicit rules.
% : SCCS/s.%

# Disable VCS-based implicit rules.
% : s.%

.SUFFIXES: .hpux_make_needs_suffix_list

# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

#Suppress display of executed commands.
$(VERBOSE).SILENT:

# A target that is always out of date.
cmake_force:
.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "C:\Users\Faiter\Programovanie\CLion 2021.3.2\bin\cmake\win\bin\cmake.exe"

# The command to remove a file.
RM = "C:\Users\Faiter\Programovanie\CLion 2021.3.2\bin\cmake\win\bin\cmake.exe" -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = E:\Programko\CLionProjects\ProgramovacieTechniky\Fait_Martin_111221_zadanie02.cpp

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = E:\Programko\CLionProjects\ProgramovacieTechniky\Fait_Martin_111221_zadanie02.cpp\cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/zadanie02.dir/depend.make
# Include any dependencies generated by the compiler for this target.
include CMakeFiles/zadanie02.dir/compiler_depend.make

# Include the progress variables for this target.
include CMakeFiles/zadanie02.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/zadanie02.dir/flags.make

CMakeFiles/zadanie02.dir/Fait_Martin_111221_zadania02.cpp.obj: CMakeFiles/zadanie02.dir/flags.make
CMakeFiles/zadanie02.dir/Fait_Martin_111221_zadania02.cpp.obj: ../Fait_Martin_111221_zadania02.cpp
CMakeFiles/zadanie02.dir/Fait_Martin_111221_zadania02.cpp.obj: CMakeFiles/zadanie02.dir/compiler_depend.ts
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=E:\Programko\CLionProjects\ProgramovacieTechniky\Fait_Martin_111221_zadanie02.cpp\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/zadanie02.dir/Fait_Martin_111221_zadania02.cpp.obj"
	C:\Users\Faiter\PROGRA~1\CLION2~1.2\bin\mingw\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -MD -MT CMakeFiles/zadanie02.dir/Fait_Martin_111221_zadania02.cpp.obj -MF CMakeFiles\zadanie02.dir\Fait_Martin_111221_zadania02.cpp.obj.d -o CMakeFiles\zadanie02.dir\Fait_Martin_111221_zadania02.cpp.obj -c E:\Programko\CLionProjects\ProgramovacieTechniky\Fait_Martin_111221_zadanie02.cpp\Fait_Martin_111221_zadania02.cpp

CMakeFiles/zadanie02.dir/Fait_Martin_111221_zadania02.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/zadanie02.dir/Fait_Martin_111221_zadania02.cpp.i"
	C:\Users\Faiter\PROGRA~1\CLION2~1.2\bin\mingw\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E E:\Programko\CLionProjects\ProgramovacieTechniky\Fait_Martin_111221_zadanie02.cpp\Fait_Martin_111221_zadania02.cpp > CMakeFiles\zadanie02.dir\Fait_Martin_111221_zadania02.cpp.i

CMakeFiles/zadanie02.dir/Fait_Martin_111221_zadania02.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/zadanie02.dir/Fait_Martin_111221_zadania02.cpp.s"
	C:\Users\Faiter\PROGRA~1\CLION2~1.2\bin\mingw\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S E:\Programko\CLionProjects\ProgramovacieTechniky\Fait_Martin_111221_zadanie02.cpp\Fait_Martin_111221_zadania02.cpp -o CMakeFiles\zadanie02.dir\Fait_Martin_111221_zadania02.cpp.s

# Object files for target zadanie02
zadanie02_OBJECTS = \
"CMakeFiles/zadanie02.dir/Fait_Martin_111221_zadania02.cpp.obj"

# External object files for target zadanie02
zadanie02_EXTERNAL_OBJECTS =

zadanie02.exe: CMakeFiles/zadanie02.dir/Fait_Martin_111221_zadania02.cpp.obj
zadanie02.exe: CMakeFiles/zadanie02.dir/build.make
zadanie02.exe: CMakeFiles/zadanie02.dir/linklibs.rsp
zadanie02.exe: CMakeFiles/zadanie02.dir/objects1.rsp
zadanie02.exe: CMakeFiles/zadanie02.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=E:\Programko\CLionProjects\ProgramovacieTechniky\Fait_Martin_111221_zadanie02.cpp\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable zadanie02.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\zadanie02.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/zadanie02.dir/build: zadanie02.exe
.PHONY : CMakeFiles/zadanie02.dir/build

CMakeFiles/zadanie02.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\zadanie02.dir\cmake_clean.cmake
.PHONY : CMakeFiles/zadanie02.dir/clean

CMakeFiles/zadanie02.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" E:\Programko\CLionProjects\ProgramovacieTechniky\Fait_Martin_111221_zadanie02.cpp E:\Programko\CLionProjects\ProgramovacieTechniky\Fait_Martin_111221_zadanie02.cpp E:\Programko\CLionProjects\ProgramovacieTechniky\Fait_Martin_111221_zadanie02.cpp\cmake-build-debug E:\Programko\CLionProjects\ProgramovacieTechniky\Fait_Martin_111221_zadanie02.cpp\cmake-build-debug E:\Programko\CLionProjects\ProgramovacieTechniky\Fait_Martin_111221_zadanie02.cpp\cmake-build-debug\CMakeFiles\zadanie02.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/zadanie02.dir/depend

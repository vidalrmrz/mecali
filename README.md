# Mecali

## Repository 

In this repository I will be using an approach of TBD that allows teams that have a big number of developers to keep a neat track of master and all of their features that are integrated.

## Clean-MVVM Architecture implementation

In this proyect you will be seeing an implementation of Clean Architecture, using the presentatio(app), domain and data modules and inside the presentation module you will be seeing an MVVM implementation to comunicate the XML with viewModels and have a way to be responsive and remove all logic from views.

### Clean
[![Clean](https://github.com/vidalrmrz/mecali/docs/clean_arch.png)]

I have decided to create the modules in the same proyect, but with a separation to avoid any sort of missimplementation of the real responsabilities y the clean Architecture, so app only sees domain and domain is the one seeing data.

### MVVM

With MVVM I have one viewModel per view to avoid sharing viewModels and have a better separation of responsibilities

### Dependenci Injection

To implement dependency injection I have decided to use Koin given that it does not generate code, proven to be better implementation in small projects.
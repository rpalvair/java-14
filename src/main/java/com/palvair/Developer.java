package com.palvair;

sealed class Developer permits BackEndDeveloper, FrontEndDeveloper, FullStackDeveloper {
}

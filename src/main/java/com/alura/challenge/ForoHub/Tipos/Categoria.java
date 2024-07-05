package com.alura.challenge.ForoHub.Tipos;

public enum Categoria  {

Lenguajes_Programacion("Lenguajes de Programacion", new String[]{
            "Java",
            "Swift",
            "Kotlin",
            "TypeScript",
            "Go",
            "PHP",
            "Python",
            "JavaScript",
            "C#",
            "C++",
            "Ruby",
            "HTML/CSS"
            }),
Frameworks("Frameworks ", new String[]{
            "Spring Framework",
            "React.js",
            "Angular",
            "Vue.js",
            "Express.js",
            "Django",
            "Quasar",
            "Flutter",
            ".NET Core",
            "Ruby on Rails",
            "Laravel"
}),
Desarrollo_Software("Desarrollo", new String[]{
            "Frontend Development",
            "Backend Development",
            "Desarrollador Full Stack",
            "Arquitectura de software",
            "Seguridad ",
            "Experiencia de Usuario (UX)",
            "Diseño Web"
}),
Aplicaciones_Mobiles("Aplicaciones Moviles", new String[]{
            "iOS Development",
            "Android Development",
            "Desarrollo Cross-Platform",
            "Diseño de Interfaz de Usuario Móvil (UI)",
            "Desarrollo de Juegos Móviles"
}),
Devops ("DevOps", new String[]{
            "Integración Continua / Entrega Continua (CI/CD)",
            "Administración de Sistemas",
            "Contenedores (Docker, Kubernetes)",
            "Gestión de Configuración (Ansible, Chef, Puppet)",
            "Monitoreo y Registro"
}),
Bases_Datos("Bases de Datos", new String[]{
            "MySQL",
            "PostegreSQL",
            "Microsoft SQL Server",
            "Oracle Database",
            "MongoDB",
            "MariaDB"
}),
Inteligencia_Artificial("Inteligencia Artificial ", new String[]{
            "Machine Learning",
            "Deep Learning",
            "Procesamiento del Lenguaje Natural (NLP)",
            "Visión por Computadora",
            "Análisis de Datos",
            "Minería de Datos"
}),
Seguridad_Informatica("Seguridad Informatica", new String[]{
            "Ciberseguridad",
            "Ethical Hacking",
            "Auditoría de Seguridad",
            "Protección de Datos",
            "Criptografía"
}),
Otros("Otros", new String[]{
            "Metodologías de Desarrollo Ágil",
            "Desarrollo de Videojuegos",
            "Desarrollo de Software Empresarial",
            "Tutoriales y Recursos de Aprendizaje",
            "Carrera y Desarrollo Profesional"
});

private final String descripcion;
private final String[] subcategorias;

Categoria(String descripcion, String[] subcategorias) {
    this.descripcion = descripcion;
    this.subcategorias = subcategorias;
}

public String getDescripcion() {
    return descripcion;
}

public String[] getSubcategorias() {
    return subcategorias;
}
}
### LOOK AT POM.XML PLUGIN SECTION FOR WINDOWS / MACOS OPERATING SYSTEM FOR PROTO


1-Project set up according to udemy video reference
https://www.udemy.com/course/grpc-the-complete-guide-for-java-developers/learn/lecture/42153632#overview

2-source code pom xml may be problematic for some os due to ${os.detected.classifier} property so use the pom in the project.
(do not change)

option java_multiple_files = true; property makes that separate classes in a single protofile is generated separately or together in same file.


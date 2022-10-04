import { Button } from "@nextui-org/react";

interface AppButtonProps {
  label: string;
  onClick?: () => void;
}

export default function AppButton({ label }: AppButtonProps) {
  return (
    <Button
      style={{
        marginTop: "30px",
        width: "40%",
        position: "absolute",
        display: "flex",
        flexDirection: "column",
        left: "30%",
      }}
    >
      {label}
    </Button>
  );
}
